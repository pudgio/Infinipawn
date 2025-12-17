package infinipawn.patches;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.friendly.human.humanShop.ShopManager;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = ShopManager.class, name = "serverTick", arguments = {necesse.engine.world.WorldEntity.class, necesse.engine.network.server.Server.class})
public class ShopManagerServerTickPatch {
    @Advice.OnMethodExit
    static void onExit(@Advice.This ShopManager shopManager) {
        shopManager.shopWealth = Integer.MAX_VALUE;
    }
}
