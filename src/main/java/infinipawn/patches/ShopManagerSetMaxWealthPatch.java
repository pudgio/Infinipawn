package infinipawn.patches;

import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.entity.mobs.friendly.human.humanShop.ShopManager;
import net.bytebuddy.asm.Advice;

@ModMethodPatch(target = ShopManager.class, name = "setMaxShopWealth", arguments = {int.class, int.class})
public class ShopManagerSetMaxWealthPatch {
    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    static boolean onEnter(@Advice.This ShopManager shopManager, @Advice.Argument(0) int maxWealth, @Advice.Argument(1) int changePerDay) {
        shopManager.maxShopWealthRange = null;
        shopManager.shopWealth = -1;
        return true;
    }
}
