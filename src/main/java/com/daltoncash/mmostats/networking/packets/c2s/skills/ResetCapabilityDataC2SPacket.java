package com.daltoncash.mmostats.networking.packets.c2s.skills;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.archery.PlayerArcheryLevelProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.EfficientMarksmanUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.HunterUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.InsecurityUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.LeftClickUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.QuickshotUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SharpshooterUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SniperUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.SweetSpotArcheryUpgradeProvider;
import com.daltoncash.mmostats.capabilities.archery.upgrades.UnabatedUpgradeProvider;
import com.daltoncash.mmostats.capabilities.chopping.PlayerChoppingLevelProvider;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.GrannySmithUpgradeProvider;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.HardwoodUpgradeProvider;
import com.daltoncash.mmostats.capabilities.chopping.upgrades.StrongArmsUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.PlayerCombatLevelProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.DodgeRollUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.FreeArrowsUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.OvercomeUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.RagnorokUpgradeProvider;
import com.daltoncash.mmostats.capabilities.combat.upgrades.TakeStanceUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.PlayerFarmingLevelProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.CarnivoreUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.EggerUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.SugarRushUpgradeProvider;
import com.daltoncash.mmostats.capabilities.farming.upgrades.WellFedUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningExpProvider;
import com.daltoncash.mmostats.capabilities.mining.PlayerMiningLevelProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.JunkBlocksDropExpUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NightVisionUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.NoJunkBlocksUpgradeProvider;
import com.daltoncash.mmostats.capabilities.mining.upgrades.ObsidianBreakerUpgradeProvider;
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerLevelExpProvider;
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerLevelProvider;
import com.daltoncash.mmostats.capabilities.playerlevel.PlayerUpgradePointsProvider;
import com.daltoncash.mmostats.capabilities.swords.PlayerSwordsLevelProvider;
import com.daltoncash.mmostats.networking.ModMessages;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerLevelExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerUpgradePointsDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.EfficientMarksmanUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.HunterUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.InsecurityUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.LeftClickUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.QuickshotUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.SharpshooterUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.SniperUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.SweetSpotArcheryUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.archeryUpgrades.UnabatedUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.GrannySmithUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.HardwoodUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.StrongArmsUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.DodgeRollUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.FreeArrowsUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.OvercomeUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.RagnorokUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.TakeStanceUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.CarnivoreUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.EggerUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.SugarRushUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.WellFedUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NightVisionDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.ObsidianBreakerDataSyncS2CPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class ResetCapabilityDataC2SPacket {
	public ResetCapabilityDataC2SPacket() {

	}

	public ResetCapabilityDataC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			ServerPlayer player = context.getSender();
			
			//Resetting Upgrades
			player.getCapability(PlayerUpgradePointsProvider.PLAYER_UPGRADE_POINTS).ifPresent(upgradePoints -> {
				upgradePoints.subPlayerUpgradePoints(1000);
				ModMessages.sendToPlayer(new PlayerUpgradePointsDataSyncS2CPacket(upgradePoints.getPlayerUpgradePoints()), player);
			});
			
			//Skills
			player.getCapability(PlayerLevelProvider.PLAYER_LEVEL).ifPresent(playerLevel -> {
				playerLevel.subPlayerLevel(1000);
				ModMessages.sendToPlayer(new PlayerLevelDataSyncS2CPacket(playerLevel.getPlayerLevel()), player);
			});
			player.getCapability(PlayerLevelExpProvider.PLAYER_LEVEL_EXP).ifPresent(playerLevelExp -> {
				playerLevelExp.subLevelExp(1000);
				ModMessages.sendToPlayer(new PlayerLevelExpDataSyncS2CPacket(playerLevelExp.getLevelExp()), player);
			});
			
			player.getCapability(PlayerMiningExpProvider.PLAYER_MINING_EXP).ifPresent(miningExp -> {
				miningExp.subMiningExp(100000);
				ModMessages.sendToPlayer(new MiningExpDataSyncS2CPacket(miningExp.getMiningExp()), player);
			});
			player.getCapability(PlayerMiningLevelProvider.PLAYER_MINING_LEVEL).ifPresent(miningLevel -> {
				miningLevel.subMiningLevel(100);
				ModMessages.sendToPlayer(new MiningLevelDataSyncS2CPacket(miningLevel.getMiningLevel()), player);
			});
			player.getCapability(PlayerArcheryLevelProvider.PLAYER_ARCHERY_LEVEL).ifPresent(archeryLevel -> {
				archeryLevel.subArcheryLevel(100);
				ModMessages.sendToPlayer(new ArcheryLevelDataSyncS2CPacket(archeryLevel.getArcheryLevel()), player);
			});
			player.getCapability(PlayerChoppingLevelProvider.PLAYER_CHOPPING_LEVEL).ifPresent(choppingLevel -> {
				choppingLevel.subChoppingLevel(100);
				ModMessages.sendToPlayer(new ChoppingLevelDataSyncS2CPacket(choppingLevel.getChoppingLevel()), player);
			});
			player.getCapability(PlayerCombatLevelProvider.PLAYER_COMBAT_LEVEL).ifPresent(combatLevel -> {
				combatLevel.subCombatLevel(100);
				ModMessages.sendToPlayer(new CombatLevelDataSyncS2CPacket(combatLevel.getCombatLevel()), player);
			});
			player.getCapability(PlayerFarmingLevelProvider.PLAYER_FARMING_LEVEL).ifPresent(farmingLevel -> {
				farmingLevel.subFarmingLevel(100);
				ModMessages.sendToPlayer(new FarmingLevelDataSyncS2CPacket(farmingLevel.getFarmingLevel()), player);
			});
			player.getCapability(PlayerSwordsLevelProvider.PLAYER_SWORDS_LEVEL).ifPresent(swordsLevel -> {
				swordsLevel.subSwordsLevel(100);
				ModMessages.sendToPlayer(new SwordsLevelDataSyncS2CPacket(swordsLevel.getSwordsLevel()), player);
			});
			//Mining Upgrades
			player.getCapability(JunkBlocksDropExpUpgradeProvider.JUNK_BLOCKS_DROP_EXP).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new JunkBlocksDropExpDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(NightVisionUpgradeProvider.NIGHT_VISION).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new NightVisionDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(NoJunkBlocksUpgradeProvider.NO_JUNK_BLOCKS).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new NoJunkBlocksDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(ObsidianBreakerUpgradeProvider.OBSIDIAN_BREAKER).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new ObsidianBreakerDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			
			//Archery Upgrades
			player.getCapability(EfficientMarksmanUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new EfficientMarksmanUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(HunterUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new HunterUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(InsecurityUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new InsecurityUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(LeftClickUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new LeftClickUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(QuickshotUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new QuickshotUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(SharpshooterUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new SharpshooterUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(SniperUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new SniperUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(SweetSpotArcheryUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new SweetSpotArcheryUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(UnabatedUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new UnabatedUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			
			//Chopping Upgrades
			player.getCapability(GrannySmithUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new GrannySmithUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(HardwoodUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new HardwoodUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(StrongArmsUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new StrongArmsUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			
			//Combat Upgrades
			player.getCapability(DodgeRollUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new DodgeRollUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(FreeArrowsUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new FreeArrowsUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(OvercomeUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new OvercomeUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(RagnorokUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new RagnorokUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(TakeStanceUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new TakeStanceUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			
			//Farming Upgrades
			player.getCapability(CarnivoreUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new CarnivoreUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(EggerUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new EggerUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(SugarRushUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new SugarRushUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			player.getCapability(WellFedUpgradeProvider.IS_UPGRADED).ifPresent(isUpgraded -> {
				isUpgraded.setUpgradeLevel(0);
				ModMessages.sendToPlayer(new WellFedUpgradeDataSyncS2CPacket(isUpgraded.getUpgradeLevel()), player);
			});
			
		});
		return true;
	}
}
