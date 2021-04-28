package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	public AddPlace AddplacePayload(String name, String language, String address) {
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setLocation(null);
		p.setPhone_number("(+91) 983 893 3937");
		p.setName(name);
		p.setWebsite("http://google.com");
		List<String> str= new ArrayList<>();
		str.add("shoe park");
		str.add("shop");
		p.setTypes(str);
		Location l= new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);	
		System.out.println("Hi this is rajat");
		return p;
		
	}

}
