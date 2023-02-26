package me.fullpage.bot.example.listeners;

import me.fullpage.bot.api.module.Module;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ExampleListener extends ListenerAdapter {

    private final Module module;

    public ExampleListener(Module module) {
        this.module = module;
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Member member = event.getMember();
        module.getLogger().info(member.getUser().getAsTag() + " joined " + member.getGuild().getName());
    }

}
