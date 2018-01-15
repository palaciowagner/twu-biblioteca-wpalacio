package com.twu.biblioteca.entities.menu;

import com.twu.biblioteca.entities.Biblioteca;
import com.twu.biblioteca.entities.Profile;
import com.twu.biblioteca.helpers.CliHelper;

public class SeeProfileOption extends MenuOption {
    public SeeProfileOption(int optionNumber, Biblioteca biblioteca) {
        super(optionNumber, "See my profile" ,biblioteca);
    }

    @Override
    public void view() {
        Profile userProfile = this.getBiblioteca().getLoggedInUser().getProfile();
        CliHelper.buildFormattedLine("Name", "Email", "Phone");
        CliHelper.buildFormattedLine(userProfile.getName(), userProfile.getEmail(), userProfile.getPhone());
    }
}
