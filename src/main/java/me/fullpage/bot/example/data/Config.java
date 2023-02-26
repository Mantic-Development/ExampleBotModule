package me.fullpage.bot.example.data;

import de.exlll.configlib.BotYamlConfiguration;
import de.exlll.configlib.annotation.Comment;
import me.fullpage.bot.api.module.Module;

public class Config extends BotYamlConfiguration {

    public Config(Module module) {
        super(module, "config.yml");
    }

    @Comment("The message to log on startup")
    public String startupMessage = "Now doing stuff!";

}
