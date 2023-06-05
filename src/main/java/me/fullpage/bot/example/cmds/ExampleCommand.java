package me.fullpage.bot.example.cmds;

import me.fullpage.bot.api.annotations.Category;
import me.fullpage.bot.api.annotations.Command;
import me.fullpage.bot.api.args.Option;
import me.fullpage.bot.api.commands.Categories;
import me.fullpage.bot.api.commands.ISlashCommand;
import me.fullpage.bot.api.events.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Category(category = Categories.MISC)
// The below is the command label, and the description
@Command(label = "example", description = "Example command")
public class ExampleCommand implements ISlashCommand {

    @Override
    public OptionData[] getOptions() {
        return new OptionData[]{
                new OptionData(OptionType.USER, "user", "User to say hello", false)

        };
    }

    @Override
    public void onCommand(@NotNull CommandEvent event, @NotNull String s, @Nullable Guild guild, @Nullable Member member, @NotNull MessageChannel messageChannel) {

        Option user = event.getOption("user"); // Get the user option
        if (user != null) { // Checks if it's been provided as an argument
            event.reply("Hello " + user.getAsUser().getName() + "!").queue();
            return;
        }


        event.reply("Hello world!").queue();

    }

    @Override
    public List<Permission> getPermissions() {
        return new ArrayList<>();
    }

    @Override
    public HashSet<PermissionData> getPermissionData() {
        return new HashSet<>();
    }
}
