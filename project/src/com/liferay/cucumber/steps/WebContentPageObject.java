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

import java.util.List;

import cucumber.api.DataTable;

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class WebContentPageObject extends BasePageObject {

	/*public void addWebContent(DataTable webContent) throws Exception {
		List<List<String>> data = webContent.raw();

		String title = data.get(0).get(0);
		String content = data.get(0).get(1);

		boolean wcdPortlet = isWCDPortletPresent();

		if (wcdPortlet) {
			selectFrame("//iframe");
		}

		click("//*[@data-qa-id='addButton']");
		clickLink("Basic Web Content");

		typeField("Title", title);
		typeEditor(content);

		clickButton("Publish");

		if (wcdPortlet) {
			selectFrame("relative=top");
		}
	}*/

	public void addWebContentInAdminPortlet(DataTable webContent) throws Exception {
		List<List<String>> data = webContent.raw();

		String title = data.get(0).get(0);
		String content = data.get(0).get(1);

		click("//*[@data-qa-id='addButton']");
		clickLink("Basic Web Content");

		typeField("Title", title);
		typeEditor(content);

		clickButton("Publish");
	}

	public void addWebContentInWCDPortlet(DataTable webContent) throws Exception {
		List<List<String>> data = webContent.raw();

		String title = data.get(0).get(0);
		String content = data.get(0).get(1);

		clickHidden("//*[@data-qa-id='addButton']");
		clickLink("Basic Web Content");

		selectFrame("//iframe");

		typeField("Title", title);
		typeEditor(content);

		clickButton("Publish");

		selectFrame("relative=top");
	}

	/*public boolean isWCDPortletPresent() throws Exception {
		return isElementPresent(webContentDisplayPortlet);
	}*/

	public void viewWebContentInAdminPortlet(DataTable webContent) throws Exception {
		List<List<String>> data = webContent.raw();

		String title = data.get(0).get(0);
		String content = data.get(0).get(1);

		String titleLocator = "//li[contains(@data-title,'" + title + "')]//div[@class=' list-group-item-content']//a";

		click(titleLocator);

		assertValueField("Title", title);
		assertTextEditor(content);
	}

	public void viewWebContentInWCDPortlet(DataTable webContent) throws Exception {
		List<List<String>> data = webContent.raw();

		String title = data.get(0).get(0);
		String content = data.get(0).get(1);

		assertText(webContentTitleInWCDPortletLocator, title);
		assertText(webContentContentInWCDPortletLocator, content);
	}

	private String webContentTitleInWCDPortletLocator = "//div/h2[contains(@class,'portlet-title-text')]";

	private String webContentContentInWCDPortletLocator = "//div[@class='journal-content-article']/p";

	//private String webContentDisplayPortlet = "//div[contains(@class,'portlet')]/h2[contains(.,'Web Content Display')]";
}
