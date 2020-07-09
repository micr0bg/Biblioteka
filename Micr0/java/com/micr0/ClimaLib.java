package com.micr0;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.MyAnnotationCallback;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import com.micr0.util.Database;
import com.micr0.util.FilteredTree;

/**
 * @author Micr0 (iliq zlatanov)
 */
public class ClimaLib extends JPanel implements TreeSelectionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTree list;
	private JSplitPane splitPane;
	public JPanel viewer;
	public SwingController controller;
	public String filePath;
	public Connection con = null;
	public Statement stm = null;
	public DefaultMutableTreeNode root;
	public FilteredTree ftree;
	
	public ClimaLib()
	{
		try
		{
			try
			{
				con = Database.getConnection();
				stm = con.createStatement();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			ArrayList<Object> list = new ArrayList<>();
			list.add("Библиотека");
			String sql = "SELECT * from category";
			
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next())
			{
				Object value[] =
				{
					rs.getString(1),
					rs.getString(2)
				};
				list.add(value);
			}
			Object hierarchy[] = list.toArray();
			root = processHierarchy(hierarchy);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		ftree = new FilteredTree(root);
		// Create the list of images and put it in a scroll pane.
		list = ftree.getTree();
		list.addTreeSelectionListener(this);
		// JScrollPane listScrollPane = new JScrollPane(list);
		
		viewer = new JPanel();
		viewer.setBackground(Color.GRAY);
		viewer.setLayout(new GridLayout(0, 1, 0, 3));
		// Create a split pane with the two scroll panes in it.
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ftree, viewer);
		splitPane.setBackground(Color.GRAY);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		
		// Provide minimum sizes for the two components in the split pane.
		Dimension minimumSize = new Dimension(100, 50);
		ftree.setMinimumSize(minimumSize);
		viewer.setMinimumSize(minimumSize);
		
		// Provide a preferred size for the split pane.
		splitPane.setPreferredSize(new Dimension(1000, 600));
		
		// build a controller
		controller = new SwingController();
		
		// Build a SwingViewFactory configured with the controller
		SwingViewBuilder factory = new SwingViewBuilder(controller);
		
		// Use the factory to build a JPanel that is pre-configured
		// with a complete, active Viewer UI.
		JPanel viewerComponentPanel = factory.buildViewerPanel();
		// factory.buildViewerPanel().setSize(getPreferredSize());
		viewer.add(viewerComponentPanel);
		
		// add copy keyboard command
		ComponentKeyBinding.install(controller, viewerComponentPanel);
		
		// add interactive mouse link annotation support via callback
		controller.getDocumentViewController().setAnnotationCallback(new MyAnnotationCallback(controller.getDocumentViewController()));
		
	}
	
	public DefaultMutableTreeNode processHierarchy(Object[] hierarchy)
	{
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
		try
		{
			int ctrow = 0;
			int i = 0;
			try
			{
				
				try
				{
					con = Database.getConnection();
					stm = con.createStatement();
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				String sql = "SELECT catid, catname from category";
				ResultSet rs = stm.executeQuery(sql);
				
				while (rs.next())
				{
					ctrow = rs.getRow();
				}
				String L1Nam[] = new String[ctrow];
				String L1Id[] = new String[ctrow];
				ResultSet rs1 = stm.executeQuery(sql);
				while (rs1.next())
				{
					L1Nam[i] = rs1.getString("catname");
					L1Id[i] = rs1.getString("catid");
					i++;
				}
				DefaultMutableTreeNode child, grandchild;
				for (int childIndex = 0; childIndex < L1Nam.length; childIndex++)
				{
					child = new DefaultMutableTreeNode(L1Nam[childIndex]);
					node.add(child);// add each created child to root
					String sql2 = "SELECT scatname from subcategory where catid= '" + L1Id[childIndex] + "' ";
					ResultSet rs3 = stm.executeQuery(sql2);
					while (rs3.next())
					{
						grandchild = new DefaultMutableTreeNode(rs3.getString("scatname"));
						child.add(grandchild);// add each grandchild to each child
					}
				}
				
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		catch (Exception e)
		{
		}
		
		return (node);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) list.getLastSelectedPathComponent();
		/* if nothing is selected */
		if (node == null)
			return;
		
		/* retrieve the node that was selected */
		Object nodeInfo = node.getUserObject();
		/* React to the node selection. */
		// System.out.println(nodeInfo);
		// Open a PDF document to view
		
		try
		{
			
			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM subcategory";
			
			con = Database.getConnection();
			stm = con.createStatement();
			
			// execute the query, and get a java resultset
			ResultSet rs = stm.executeQuery(query);
			
			// iterate through the java resultset
			while (rs.next())
			{
				String Name = rs.getString("scatname");
				String path = rs.getString("path");
				
				if (nodeInfo.equals(Name))
				{
					filePath = String.valueOf("resources/" + path);
					controller.openDocument(filePath);
				}
			}
			stm.close();
		}
		catch (Exception ez)
		{
			
		}
	}
	
	public JSplitPane getSplitPane()
	{
		return splitPane;
	}
	
	public FilteredTree getFilteredTree()
	{
		return ftree;
	}
	
	public DefaultMutableTreeNode getRoot()
	{
		return root;
	}
	
}