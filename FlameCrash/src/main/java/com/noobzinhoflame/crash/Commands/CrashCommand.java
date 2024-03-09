package com.noobzinhoflame.crash.Commands;

import com.noobzinhoflame.crash.Utils.CrashAPI;
import com.noobzinhoflame.crash.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrashCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("crash.use")) {
            sender.sendMessage("§cVocê não possui permissão para usar este comando.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("§cUse: /crash [player]");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("§cJogador inválido ou offline.");
            return true;
        }

        // Coloque seu nick aqui para evitar ser crashado.

        /*if (target.getName().equalsIgnoreCase("9_______________")) {
            sender.sendMessage("§cVocê não pode crashar este player");
            return true;
        }*/

        CrashAPI Crash = new CrashAPI();

        sender.sendMessage("§aCrashando jogador...");
        Crash.crashPlayer(target);
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
            public void run() {
                sender.sendMessage("§aVocê crashou o jogador " + target.getName() + " com sucesso!");
                target.getWorld().strikeLightningEffect(target.getLocation());
                target.kickPlayer("")
            }
        }, 100L);
        return true;
    }
}
