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

package com.liferay.cucumber.pages;

import com.liferay.cucumber.steps.BasePageObject;

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class AppPageObject extends BasePageObject {
	public void addApp(String appName) throws Exception {
		String addAppLocator = "//span[contains(@data-title,'" + appName + "') and contains(@class,'add-content-item')]";

		String appLoadedLocator = "//div[contains(@class,'portlet-content')]/h2[contains(.,'" + appName + "')]";

		_addPanelPageObject.searchApplication(appName);

		pauseMakeVisibleClick(addAppLocator);

		assertVisible(appLoadedLocator);
	}

	private AddPanelPageObject _addPanelPageObject = new AddPanelPageObject();
}
