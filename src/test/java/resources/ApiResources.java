package resources;
//enum is special class in java whihc has collections of constants and methods
public enum ApiResources {
   AddplaceApi("/maps/api/place/add/json"),
   getPlaceApi(""),
   deletePlaceApi("");
	
	private String resource;
	
	ApiResources(String resource){
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
	
}
