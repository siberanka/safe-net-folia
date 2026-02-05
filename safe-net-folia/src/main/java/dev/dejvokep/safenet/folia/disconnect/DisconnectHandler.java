/*
 * Copyright 2025 https://dejvokep.dev/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.dejvokep.safenet.folia.disconnect;

import dev.dejvokep.safenet.folia.SafeNetFolia;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Class responsible for handling player disconnection.
 */
public class DisconnectHandler {

    /**
     * Default disconnect message used if the one provided in the config is invalid.
     */
    private static final String DEFAULT_DISCONNECT_MESSAGE = "Disconnected";

    // Disconnect message
    private String message;
    // Plugin
    private final SafeNetFolia plugin;

    /**
     * Initializes the internal data.
     *
     * @param plugin the plugin
     */
    public DisconnectHandler(@NotNull SafeNetFolia plugin) {
        this.plugin = plugin;
        reload();
    }

    /**
     * Disconnects the given player using the server API. If the result of the kicking the player is important, the
     * caller must watch the call chain using server events.
     *
     * @param player the player to disconnect
     */
    public void play(@NotNull Player player) {
        // Deprecated on Paper servers
        player.kickPlayer(message);
    }

    /**
     * Reloads the internal configuration.
     */
    public void reload() {
        // Deprecated on Paper servers
        message = ChatColor.translateAlternateColorCodes('&', plugin.getConfiguration().getString("disconnect-message", DEFAULT_DISCONNECT_MESSAGE));
    }

    /**
     * Returns the disconnect message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
