package schauweg.unsuspiciousstew.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import schauweg.unsuspiciousstew.StewInfo;

import java.util.List;

@Mixin(ItemStack.class)
public class MixinItemStack {


    @Inject(at = @At("RETURN"), method = "getTooltip")
    public void onInjectTooltip(PlayerEntity player, TooltipContext context, CallbackInfoReturnable<List<Text>> ci) {
        StewInfo.onInjectTooltip(this, ci.getReturnValue());
    }


}