/**
 * 
 */
package com.naguiar.catalog.enums;

/**
 * @author naty
 *
 */
public enum Recording {
	
	LIVE("LIVE","Live"),
	STUDIO("STUDIO", "Studio");
	
	private String name;
    private String description;
    
    Recording(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
}
