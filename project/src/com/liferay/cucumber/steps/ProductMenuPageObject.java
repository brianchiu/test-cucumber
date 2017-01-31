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

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class ProductMenuPageObject extends BasePageObject {
	public void expandCategory(String category) throws Exception {
		String categoryCollapsed = "//div[a[@aria-expanded='true']]/../..//a[@aria-expanded='false' and contains(.,'" + category + "')]";

		String categoryExpanded = "//div[a[@aria-expanded='true']]/../..//a[@aria-expanded='true' and contains(.,'" + category + "')]";

		if (isElementPresent(categoryCollapsed)) {
			click(categoryCollapsed);
		}

		assertVisible(categoryExpanded);
	}

	public void expandProductMenu() throws Exception {
		if (!isElementPresent(productMenuOpened)) {
			click(toggle);
		}

		assertVisible(productMenuOpened);
	}

	public void gotoSitePortlet(String category, String portlet) throws Exception {
		String portletLocator = "//div[a[@aria-expanded='true']]//a[contains(@id,'Portlet') and @data-title='" + portlet + "']";

		expandCategory(category);

		click(portletLocator);

		assertText(headerTitle, portlet);
	}

	private String headerTitle = "//*[@data-qa-id='headerTitle']";

	private String productMenuOpened = "//div[contains(@id,'sidenavSliderId') and not(contains(@class,'closed')) and not(contains(@class,'transition'))]";

	private String toggle = "//*[@data-qa-id='productMenu']";
}
