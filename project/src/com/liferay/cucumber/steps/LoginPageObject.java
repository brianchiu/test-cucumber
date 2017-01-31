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
public class LoginPageObject extends BasePageObject {

	public void login(String emailAddress, String password) throws Exception {
		open("http://localhost:8080/");

		clickLink("Sign In");

		typeField("Email Address", emailAddress);
		typeField("Password", password);

		clickButton("Sign In");

		assertVisible(userAvatarImage);
	}

	public void logout() throws Exception {
		String productMenuTabExpanded =
			"//*[@data-qa-id='productMenuUserPanelCategory']" +
				"[@aria-expanded='true']";

		click(userAvatarImage);

		assertVisible(productMenuTabExpanded);

		clickLink("Sign Out");

		assertVisibleLink("Sign In");
	}

	private String userAvatarImage =
		"//*[@data-qa-id='openUserMenu'] | " +
			"//span[@class='user-avatar-image']";

}
