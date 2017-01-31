/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.cucumber.steps;

import cucumber.api.java.en.Given;

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class BaseSteps {

    @Given("^I click the \"([^\"]*)\" button$")
    public void clickButton(String button) throws Exception {
        _basePageObject.clickButton(button);
    }

    @Given("^I click the \"([^\"]*)\" link$")
    public void clickLink(String link) throws Exception {
        _basePageObject.clickLink(link);
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void open(String url) throws Exception {
        _basePageObject.open(url);
    }

    @Given("I start selenium")
    public void startSelenium() throws Exception {
        _basePageObject.startSelenium();
    }

    @Given("I stop selenium")
    public void stopSelenium() throws Exception {
        _basePageObject.stopSelenium();
    }

    @Given("^I enter \"([^\"]*)\" in the \"([^\"]*)\" field$")
    public void typeField(String text, String field) throws Exception {
        _basePageObject.typeField(field, text);
    }

    private BasePageObject _basePageObject = new BasePageObject();

}