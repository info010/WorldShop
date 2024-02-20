package org.info_0.worldshop;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public final class WorldShop extends JavaPlugin {

    private static WorldShop instance;

    private static Economy econ;

    @Override
    public void onEnable() {
        instance = this;
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }


    }

    @Override
    public void onDisable() {

    }

    private static void registerListeners(){

    }

    private static void registerCommands(){

    }

    public static WorldShop getInstance(){
        return instance;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
