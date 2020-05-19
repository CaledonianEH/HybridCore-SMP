/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.files;


import java.util.List;

public class GuiDefault {
    public static void gui(){
        GuiConfig.get().addDefault("name", "&cPlayer &fstatistics");
        GuiConfig.get().addDefault("weapon-stats-name", "&f* &cWeapon &fStatistics &7(Global) &f*");
    }
}
