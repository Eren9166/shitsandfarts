package net.qweren.shitsandfarts.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class ModSounds{

    public static final Identifier FART_SOUND_ID = new Identifier("shitsandfarts:fart_sounds");
    public static final Identifier SMALL_FART_ID = new Identifier("shitsandfarts:small_fart");
    public static SoundEvent FART_SOUND_EVENT = SoundEvent.of(FART_SOUND_ID);
    public static SoundEvent SMALL_FART_EVENT = SoundEvent.of(SMALL_FART_ID);

}