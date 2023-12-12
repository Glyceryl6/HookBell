package com.glyceryl6.hook_bell;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Main.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void registerVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            ItemStack baseCostA = Items.BELL.getDefaultInstance();
            ItemStack costB = new ItemStack(Items.EMERALD, 5);
            ItemStack result = Main.HOOK_BELL_ITEM.get().getDefaultInstance();
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(5).add((trader, rand) -> new MerchantOffer(baseCostA, costB, result, (3), 30, (0.05F)));
        }
    }

}