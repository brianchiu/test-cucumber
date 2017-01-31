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

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class WebContentSteps {
	@When("I add the following Web Content in the admin portlet$")
	public void addWebContentInAdminPortlet(DataTable webContent) throws Exception {
		_webContentPageObject.addWebContentInAdminPortlet(webContent);
	}

	@When("I add the following Web Content in the WCD portlet$")
	public void addWebContentInWCDPortlet(DataTable webContent) throws Exception {
		_webContentPageObject.addWebContentInWCDPortlet(webContent);
	}

	@Then("I should see the following Web Content in the admin portlet$")
	public void viewWebContentInAdminPortlet(DataTable webContent) throws Exception {
		_webContentPageObject.viewWebContentInAdminPortlet(webContent);
	}

	@Then("I should see the following Web Content in the WCD portlet$")
	public void viewWebContentInWCDPortlet(DataTable webContent) throws Exception {
		_webContentPageObject.viewWebContentInWCDPortlet(webContent);
	}

	private WebContentPageObject _webContentPageObject = new WebContentPageObject();
}