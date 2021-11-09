package com.epam.uitest;

import com.epam.test.pages.EpamPage;
import com.epam.test.pages.JobSearchPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstUITest extends UiTestParent {

    @Test
    public void testEpamJobSearchPage() {
        EpamPage epamPage = new EpamPage(driver);
        epamPage.open();
        JobSearchPage jobSearchPage = epamPage.clickCareersLink();
        jobSearchPage.typeSearchKeyword("Test automation");
        jobSearchPage.selectLocation("All Cities in United States");
        jobSearchPage.clickFind();
        String findingHeading = jobSearchPage.getFindingHeading();
        System.out.println(findingHeading);
        assertThat(findingHeading).contains("9");
    }
}
