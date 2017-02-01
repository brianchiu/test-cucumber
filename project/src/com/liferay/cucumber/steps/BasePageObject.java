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

import com.liferay.cucumber.selenium.LiferaySelenium;
import com.liferay.cucumber.selenium.SeleniumUtil;

/**
 * @author Michael Hashimoto
 * @author Brian Chiu
 */
public class BasePageObject {

	public BasePageObject() {
		selenium = SeleniumUtil.getSelenium();
	}

	public void assertText(String locator, String text) throws Exception {
		selenium.waitForVisible(locator);

		selenium.assertText(locator, text);
	}

	public void assertTextEditor(String text) throws Exception {
		String locator = "//div[contains(@class,'alloy-editor-container')]//div[(contains(@data-placeholder,'Write your content here...') or contains(@data-placeholder,'reply') or contains(@data-placeholder,'Content')) and contains(@title,'Rich Text Editor')]";

		selenium.waitForVisible(locator);

		assertText(locator, text);
	}

	public void assertValue(String locator, String text) throws Exception {
		selenium.waitForVisible(locator);

		selenium.assertValue(locator, text);
	}

	public void assertValueField(String field, String text) throws Exception {
		String locator = "//div[label[contains(.,'" + field + "')]]//input";

		selenium.waitForVisible(locator);

		assertValue(locator, text);
	}

	public void assertVisible(String locator) throws Exception {
		selenium.waitForVisible(locator);

		selenium.assertVisible(locator);
	}

	public void assertVisibleButton(String button) throws Exception {
		selenium.waitForVisible("//button[contains(.,'" + button + "')]");

		assertVisible("//button[contains(.,'" + button + "')]");
	}

	public void assertVisibleLink(String link) throws Exception {
		selenium.waitForVisible("//a[contains(.,'" + link + "')]");

		assertVisible("//a[contains(.,'" + link + "')]");
	}

	public void click(String locator) throws Exception {
		selenium.waitForVisible(locator);

		selenium.click(locator);

		waitForSPARefresh();
	}

	public void clickHidden(String locator) throws Exception {
		selenium.waitForElementPresent(locator);

		selenium.click(locator);
	}

	public void clickButton(String button) throws Exception {
		click("//button[contains(.,'" + button + "')]");
	}

	public void clickLink(String link) throws Exception {
		click("//a[contains(.,'" + link + "')]");
	}

	public boolean isElementPresent(String locator) throws Exception {
		return selenium.isElementPresent(locator);
	}

	public boolean isVisible(String locator) throws Exception {
		return selenium.isVisible(locator);
	}

	public void open(String url) throws Exception {
		selenium.open(url);
	}

	public void pause(String milliseconds) throws Exception {
		selenium.pause(milliseconds);
	}

	public void pauseMakeVisibleClick(String locator) throws Exception {
		selenium.waitForElementPresent(locator);

		pause("1000");

		selenium.makeVisible(locator);

		selenium.waitForVisible(locator);

		selenium.mouseDown(locator);

		pause("1000");

		selenium.mouseUp(locator);
	}

	public void selectFrame(String locator) throws Exception {
		if (locator.contains("/iframe")) {
			selenium.waitForVisible(locator);
		}

		selenium.selectFrame(locator);
	}

	public void startSelenium() throws Exception {
		selenium = SeleniumUtil.getSelenium();
	}

	public void stopSelenium() throws Exception {
		SeleniumUtil.stopSelenium();
	}

	public void type(String locator, String text) throws Exception {
		selenium.waitForVisible(locator);

		selenium.type(locator , text);
	}

	public void typeField(String field, String text) throws Exception {
		String locator = "//div[label[contains(.,'" + field + "')]]//input";

		selenium.waitForVisible(locator);

		type(locator , text);
	}

	public void typeEditor(String text) throws Exception {
		String locator = "//div[contains(@class,'alloy-editor-container')]//div[(contains(@data-placeholder,'Write your content here...') or contains(@data-placeholder,'reply') or contains(@data-placeholder,'Content')) and contains(@title,'Rich Text Editor')]";

		selenium.waitForVisible(locator);

		selenium.typeEditor(locator, text);
	}

	public void waitForSPARefresh() throws Exception {
		String spaLoadingBar = "//html[contains(@class,'lfr-spa-loading')]";

		String notificationMessage = "//div[contains(@class,'lfr-notification-wrapper') and contains(@style,'height: 82px;')]";

		selenium.waitForElementNotPresent(spaLoadingBar);

		if (isElementPresent(notificationMessage) && isVisible(notificationMessage)) {
			click("//button[contains(@class,'close')]");
		}

		selenium.waitForElementNotPresent(notificationMessage);
	}

	protected LiferaySelenium selenium;

}