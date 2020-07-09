package com.micr0.options;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.micr0.data.ComboBoxData;
import com.micr0.util.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * @author Micr0 (iliq zlatanov)
 */
public class AddSubCategory extends JDialog
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public String path = "resources/";
	public File fileToSave;
	public Connection con = null;
	public Statement stm = null;
	public JComboBox<Object> comboBox;
	public ComboBoxData data;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			AddSubCategory dialog = new AddSubCategory();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public AddSubCategory()
	{
		setTitle("\u0414\u043E\u0431\u0430\u0432\u0438");
		setBounds(100, 100, 356, 257);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u041A\u0430\u0442\u0435\u0433\u043E\u0440\u044F ID:");
		lblNewLabel_1.setToolTipText("\u041C\u043E\u0433\u0430\u0442 \u0434\u0430 \u0441\u0435 \u0434\u043E\u0431\u0430\u0432\u044F\u0442 \u043D\u043E\u0432\u0438 \u043A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u0438 \u043E\u0442 \u0414\u043E\u0431\u0430\u0432\u0438 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044F \u0432\u044A\u0432 \u0420\u0435\u0434\u0430\u043A\u0442\u0438\u0440\u0430\u043D\u0435/\u0414\u043E\u0431\u0430\u0432\u0438 \u041A\u0430\u0442\u0435\u0433\u043E\u0440\u0438\u044F");
		lblNewLabel_1.setBounds(10, 22, 77, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u041C\u043E\u0434\u0435\u043B:");
		lblNewLabel_2.setBounds(10, 67, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JFormattedTextField model = new JFormattedTextField();
		model.setBounds(10, 92, 200, 20);
		contentPanel.add(model);
		
		JLabel lblNewLabel_3 = new JLabel("Файл:");
		lblNewLabel_3.setToolTipText("\u0412 \u0438\u043C\u0435\u0442\u043E \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043D\u0435 \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0441\u0430\u0434\u044A\u0440\u0436\u0430 \u0432\u0438\u0434\u044A\u0442 \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043F\u0440\u0438\u043C\u0435\u0440\u043D\u043E .pdf .exe .png \u0438 \u0442\u0435\u043C \u043F\u043E\u0434\u043E\u0431\u043D\u043E :)");
		lblNewLabel_3.setBounds(10, 128, 87, 14);
		contentPanel.add(lblNewLabel_3);
		
		JFormattedTextField ime = new JFormattedTextField();
		ime.setToolTipText("\u0412 \u0438\u043C\u0435\u0442\u043E \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043D\u0435 \u0442\u0440\u044F\u0431\u0432\u0430 \u0434\u0430 \u0441\u0430\u0434\u044A\u0440\u0436\u0430 \u0432\u0438\u0434\u044A\u0442 \u043D\u0430 \u0444\u0430\u0439\u043B\u0430 \u043F\u0440\u0438\u043C\u0435\u0440\u043D\u043E .pdf .exe .png \u0438 \u0442\u0435\u043C \u043F\u043E\u0434\u043E\u0431\u043D\u043E :)");
		ime.setBounds(10, 154, 200, 20);
		contentPanel.add(ime);
		
		JButton btnNewButton = new JButton("Намери");
		btnNewButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// parent component of the dialog
				JFrame parentFrame = new JFrame();
			    UIManager.put("FileChooser.saveButtonText","Запиши");
			    UIManager.put("FileChooser.cancelButtonText","Отказ");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Избор на Файл.");
				
				int userSelection = fileChooser.showSaveDialog(parentFrame);
				
				if (userSelection == JFileChooser.APPROVE_OPTION)
				{
					fileToSave = fileChooser.getSelectedFile();
					//System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					ime.setText(fileToSave.getName());
				}
			}
		});
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(10, 36, 200, 20);
		contentPanel.add(comboBox);
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
			
			String sql = "SELECT * from category";
			
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next())
			{
				comboBox.addItem(new ComboBoxData(rs.getInt(1), rs.getString(2)));
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		btnNewButton.setBounds(220, 153, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Създай");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AddCategory catss = new AddCategory();
				catss.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(220, 35, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Пример: text;text1;");
		lblNewLabel.setBounds(220, 95, 110, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Добре");
				okButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						try
						{
							ComboBoxData selecteditem = (ComboBoxData) comboBox.getSelectedItem();
							Connection conn = Database.getConnection();
							
							String str2, str3, str4;
							String[] astr3split;
							
							str2 = String.valueOf(selecteditem.getId());
							str3 = model.getText();
							str4 = ime.getText();
							
							astr3split = str3.split(";");
							
							for (int i = 0; i < astr3split.length; i++)
							{
								PreparedStatement pst1 = conn.prepareStatement("select max(scatid)+1 from subcategory");
								ResultSet rs = pst1.executeQuery();
								String cat_id = "";
								while (rs.next())
								{
									cat_id = rs.getString(1);
								}
								// the mysql insert statement
								String query = " insert into subcategory (scatid, catid, scatname, path)" + " values (?, ?, ?, ?)";
								
								// create the mysql insert preparedstatement
								PreparedStatement preparedStmt = conn.prepareStatement(query);
								
								preparedStmt.setString(1, cat_id.toString());
								preparedStmt.setString(2, str2);
								preparedStmt.setString(3, astr3split[i]);
								preparedStmt.setString(4, str4);
								
								// execute the preparedstatement
								preparedStmt.execute();
								
							}
							conn.close();
						}
						catch (Exception ex)
						{
							JOptionPane.showConfirmDialog(null, "Голема Грешка:" + ex.getMessage() + " ", "Грешка", JOptionPane.ERROR_MESSAGE, 1);
						}
						Object[] options =
						{
							"Добре"
						};
						int input = JOptionPane.showOptionDialog(null, "Успешно добавено раководство.", "Успех", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
						if (input == JOptionPane.YES_OPTION)
						{
							dispose();
							List<File> files = new ArrayList<>();
							files.add(fileToSave);
							for (File file : files)
							{
								try
								{
									Files.copy(file.toPath(), (new File(path + file.getName())).toPath(), StandardCopyOption.REPLACE_EXISTING);
								}
								catch (IOException e1)
								{
									JOptionPane.showConfirmDialog(null, "Голема Грешка:" + e1.getMessage() + " ", "Грешка", JOptionPane.ERROR_MESSAGE, 1);
									e1.printStackTrace();
								}
							}
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Отказ");
				cancelButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
