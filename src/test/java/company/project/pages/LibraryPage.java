package company.project.pages;

import company.project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryPage {


    public LibraryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
