package com.challenge.primes.multiplicaiton;

import java.util.List;

public class ProductMatrix {
	private String name;
	private List<Integer> columns;
	private List<Integer> rows;	
	int colNum;
	int rowNum;
	private int[][] products;
	
	public ProductMatrix(){	
		products = null;
	}
	
	public void initilize(List<Integer> col, List<Integer> row){
		columns = col;
		rows = row;
		colNum = col.size()+1;
		rowNum = row.size()+1;
		products = new int[rowNum][colNum];
		products[0][0]=0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public int[][] getProducts(){	
		for(int i=0;i<this.colNum-1;i++)
			products[0][i+1] = this.columns.get(i); 

		for(int i=0;i<this.rowNum-1;i++)
			products[i+1][0] = this.rows.get(i); 

		
		for(int i=1;i<this.colNum;i++){
			for(int j=1;j<this.rowNum;j++)
				products[i][j]=products[i][0] * products[0][j];
		}
			
		return products;
	}
	
	public int[][] getSymmetricProducts(){
		for(int i=0;i<this.colNum-1;i++)
			products[0][i+1] = this.columns.get(i); 

		for(int i=0;i<this.rowNum-1;i++)
			products[i+1][0] = this.rows.get(i); 
		
		for(int i=1;i<this.colNum;i++){
			for(int j=1;j<this.rowNum;j++){
				if(i<=j)
					products[i][j]=products[i][0]*products[0][j];
				else
					products[i][j]=products[j][i];					
			}
		}
		return products;
	}
}
