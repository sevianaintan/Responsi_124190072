package id.ac.upnyk.responsicovid.RS;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RSResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<DataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<DataItem> data){
		this.data = data;
	}

	public ArrayList<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RSResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}