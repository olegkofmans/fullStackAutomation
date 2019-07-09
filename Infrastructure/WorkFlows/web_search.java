package WorkFlows;

import Extensions.click;
import Extensions.update;
import Utilities.commonOps;

public class web_search extends commonOps{
	
	public static void go(String searchValue) {
		
		update.text(imbdMain.searchBox, searchValue);
		update.dropDownText(imbdMain.selectSearchDropDown, "Titles");
		click.go(imbdMain.searchButton);
	}

}
