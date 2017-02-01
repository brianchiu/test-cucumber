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
public class PagePageObject extends BasePageObject {
	public void addPage(String pageName) throws Exception {
		_productMenuPageObject.expandProductMenu();

		_productMenuPageObject.expandCategory("Navigation");

		click(publicPageEllipsisLocator);

		clickLink("Add Public Page");

		typeField("Name", pageName);

		clickButton("Add Page");
	}

	public void gotoPage(String pageName) throws Exception {
		clickLink(pageName);
	}

	private ProductMenuPageObject _productMenuPageObject = new ProductMenuPageObject();

	private String publicPageEllipsisLocator = "//*[@data-qa-id='publicPagesOptions']";

}
