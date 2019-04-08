package com.kitri.haksa.service;

import java.io.BufferedReader;
import java.util.ArrayList;

import com.kitri.haksa.data.HaksaDto;

public interface HaksaService {
	
	// [¸Þ¼Òµå]
	public void menu();
	
	public void registerMenu();
	
	public void register(HaksaDto haksa);
	
	public void findNameMenu();
	
	public HaksaDto findName(String name);
	
	public void deleteMenu();
	
	public int delete(String name);
	
	public void selectAll();
	
	public void processExit();
	
}
