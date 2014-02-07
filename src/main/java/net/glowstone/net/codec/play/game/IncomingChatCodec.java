package net.glowstone.net.codec.play.game;

import com.flowpowered.networking.util.ByteBufUtils;
import com.flowpowered.networking.Codec;
import io.netty.buffer.ByteBuf;
import net.glowstone.net.message.play.game.IncomingChatMessage;

import java.io.IOException;

public final class IncomingChatCodec implements Codec<IncomingChatMessage> {
    public IncomingChatMessage decode(ByteBuf buffer) throws IOException {
        return new IncomingChatMessage(ByteBufUtils.readUTF8(buffer));
    }

    public ByteBuf encode(ByteBuf buf, IncomingChatMessage message) throws IOException {
        ByteBufUtils.writeUTF8(buf, message.getText());
        return buf;
    }
}