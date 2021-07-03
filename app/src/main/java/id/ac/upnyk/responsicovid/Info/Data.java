package id.ac.upnyk.responsicovid.Info;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<InfoContentItem> content;

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setContent(ArrayList<InfoContentItem> content){
		this.content = content;
	}

	public ArrayList<InfoContentItem> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"metadata = '" + metadata + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}