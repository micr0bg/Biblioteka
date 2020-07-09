package com.micr0.data;

public class ComboBoxData
{
	private int Id;
	private String name;
		
	public ComboBoxData(int Id, String name)
	{
		this.Id = Id;
		this.name = name;
	}
	
	/**
	 * @return the code
	 */
	public int getId()
	{
		return Id;
	}
	
	/**
	 * @param Id the Id to set
	 */
	public void setId(int Id)
	{
		this.Id = Id;
	}
	
	/**
	 * @return the Name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
