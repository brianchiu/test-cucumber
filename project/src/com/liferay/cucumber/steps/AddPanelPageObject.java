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
public class AddPanelPageObject extends BasePageObject {
	public void expandAddPanel() throws Exception {
		if (!isVisible(closeButton)) {
			click(addButton);
		}
	}

	public void expandCategory(String categoryName) throws Exception {
		String collapsedCategoryLocator = "//div[@class='panel-title']/a[@aria-expanded='false' and contains(.,'" + categoryName + "')]";

		String expandedCategoryLocator = "//div[@class='panel-title']/a[@aria-expanded='true' and contains(.,'" + categoryName + "')]";

		if (isElementPresent(collapsedCategoryLocator)) {
			click(collapsedCategoryLocator);
		}

		assertVisible(expandedCategoryLocator);
	}

	public void searchApplication(String appName) throws Exception {
		expandAddPanel();

		expandCategory("Application");

		type(searchBar, appName);
	}

	private String addButton = "//*[@data-qa-id='controlMenu']//*[@data-qa-id='add']";

	private String closeButton = "//div[contains(@class,'lfr-add-panel')]//a[contains(@class,'sidenav-close')]";

	private String searchBar = "//div[contains(@class,'search-bar')]/input";
}
