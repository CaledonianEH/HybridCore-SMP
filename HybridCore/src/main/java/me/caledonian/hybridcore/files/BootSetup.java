/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.files;

public class BootSetup {
    public static void msg(){
        MessagesConfig.setup();
        MessagesDefault.defaults();
        MessagesConfig.get().options().copyDefaults(true);
        MessagesConfig.save();
    }
    public static void gui(){
        GuiConfig.setup();
        GuiDefault.gui();
        GuiConfig.get().options().copyDefaults(true);
        GuiConfig.save();
    }
}
