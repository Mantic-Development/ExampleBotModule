package me.fullpage.bot.example;

import me.fullpage.bot.api.Core;
import me.fullpage.bot.api.module.Module;
import me.fullpage.bot.example.cmds.ExampleCommand;
import me.fullpage.bot.example.data.Config;
import me.fullpage.bot.example.listeners.ExampleListener;
import net.dv8tion.jda.api.JDA;

public class ModuleMain extends Module {

    protected Config config;

    @Override
    public void onEnable() {
        JDA jda = this.getJda(); // Get the JDA instance
        Core core = this.getCore(); // Get the Core instance

        // Create the config
        config = new Config(this);
        config.loadAndSave();

        // Register listeners
        jda.addEventListener(new ExampleListener(this));

        // Register commands
        core.registerCommands(new ExampleCommand());

        // Log the startup message
        this.getLogger().info(config.startupMessage);



    }

    @Override
    public void onReload() {
        config.load();
    }
}