package com.daltoncash.mmostats.networking;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.networking.packets.c2s.AdditionalFortuneProcC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.EatFoodWhileFullC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.magicAbilities.SpawnNatureMagnetItemC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.SpawnTntC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeJunkBlocksDropExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeNoJunkBlocksC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.UpgradeObsidianBreakerC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.AncientDebrisMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.CoalMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.CopperMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.DiamondMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.EmeraldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.GlowstoneMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.GoldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.IronMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.LapisMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.NetherGoldMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.QuartzMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades.blocksmined.RedstoneMinedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainArcheryExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainArcheryLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainChoppingLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainCombatExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainCombatLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingExpFromUnseededCropsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingExpFromSeededCropsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainFarmingLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainMiningLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerLevelExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainPlayerUpgradePointsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainSwordsExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.GainSwordsLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetArcheryExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetCapabilityDataC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetChoppingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetCombatExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetFarmingExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetMiningExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetPlayerLevelExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.ResetSwordsExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.SpendPlayerUpgradePointsC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.magic.GainMagicExpC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.skills.magic.GainMagicLevelC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades.CritasticUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades.FleshWoundUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades.PerfectTimingUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades.RightClickUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades.ShieldBashUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.swordsUpgrades.SweetSpotSwordsUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.taming.SpawnTamedBeeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.taming.SpawnTamedFrogC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainNightVisionC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.HealFromRottenFleshTotalC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.SpawnArrowOnPlayerC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.HunterDropsMeatC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.GainEffectFromEatingC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.EfficientMarksmanUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.HunterUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.InsecurityUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.LeftClickUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.QuickshotUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.SharpshooterUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.SniperUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.SweetSpotArcheryUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.archeryUpgrades.UnabatedUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.GrannySmithUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.HardwoodUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.HighGroundUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.StrongArmsUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.AcaciaChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.BirchChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.CrimsonStemChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.DarkOakChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.JungleChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.MangroveChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.OakChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.SpruceChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.choppingUpgrades.totals.WarpedStemChoppedC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.DodgeRollUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.FreeArrowsUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.OvercomeUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.RagnorokUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.StableFootingUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.combatUpgrades.TakeStanceUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.CarnivoreUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.EggerUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.FastFoodUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.InsatiableUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.SugarRushUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.WellFedUpgradeC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.ApplesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.BeefEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.BeetrootEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.BreadEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.CakeEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.CarrotsEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.ChickenEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.CookiesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.FishEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.GlowBerriesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.GoldApplesEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.GoldenCarrotsEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.HoneyEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.KelpEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.MelonEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.MushroomStewEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.MuttonEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PoisonousPotatoEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PorkEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PotatoEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PufferfishEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.PumpkinPieEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.RabbitEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.RawFoodEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.RottenFleshEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.c2s.farmingUpgrades.foodEaten.SpiderEyeEatenC2SPacket;
import com.daltoncash.mmostats.networking.packets.s2c.ManaDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ArcheryLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.ChoppingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.CombatLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.FarmingLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.MiningLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerLevelExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.PlayerUpgradePointsDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.SwordsLevelDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.magic.MagicExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.skills.magic.MagicLevelDataSyncS2CPacket;
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
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.HighGroundUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.StrongArmsUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.AcaciaChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.BirchChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.CrimsonStemChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.DarkOakChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.JungleChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.MangroveChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.OakChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.SpruceChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.choppingUpgrades.totals.WarpedStemChoppedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.DodgeRollUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.FreeArrowsUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.OvercomeUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.RagnorokUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.StableFootingUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.combatUpgrades.TakeStanceUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.CarnivoreUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.EggerUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.FastFoodUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.InsatiableUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.SugarRushUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.WellFedUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.ApplesEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.BeefEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.BeetrootEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.BreadEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.CakeEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.CarrotsEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.ChickenEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.CookiesEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.FishEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.GlowBerriesEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.GoldApplesEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.GoldenCarrotsEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.HoneyEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.KelpEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.MelonEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.MushroomStewEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.MuttonEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.PoisonousPotatoEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.PorkEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.PotatoEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.PufferfishEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.PumpkinPieEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.RabbitEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.RawFoodEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.RottenFleshEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.farmingUpgrades.foodEaten.SpiderEyeEatenDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.JunkBlocksDropExpDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NightVisionDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.NoJunkBlocksDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.ObsidianBreakerDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.AncientDebrisMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.CoalMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.CopperMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.DiamondMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.EmeraldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.GlowstoneMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.GoldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.IronMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.LapisMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.NetherGoldMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.QuartzMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.miningUpgrades.blocksmined.RedstoneMinedDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.CritasticUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.FleshWoundUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.PerfectTimingUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.RightClickUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.ShieldBashUpgradeDataSyncS2CPacket;
import com.daltoncash.mmostats.networking.packets.s2c.upgrades.swordsUpgrades.SweetSpotSwordsUpgradeDataSyncS2CPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

	public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MmoStatsMod.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;
        
//----------C2S---MISC-----------------------------------------------------------------------      
        net.messageBuilder(AdditionalFortuneProcC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(AdditionalFortuneProcC2SPacket::new)
				.encoder(AdditionalFortuneProcC2SPacket::toBytes)
				.consumerMainThread(AdditionalFortuneProcC2SPacket::handle)
				.add();
        net.messageBuilder(EatFoodWhileFullC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(EatFoodWhileFullC2SPacket::new)
				.encoder(EatFoodWhileFullC2SPacket::toBytes)
				.consumerMainThread(EatFoodWhileFullC2SPacket::handle)
				.add();
        net.messageBuilder(SpawnTntC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpawnTntC2SPacket::new)
				.encoder(SpawnTntC2SPacket::toBytes)
				.consumerMainThread(SpawnTntC2SPacket::handle)
				.add();
		net.messageBuilder(GainEffectFromEatingC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainEffectFromEatingC2SPacket::new)
				.encoder(GainEffectFromEatingC2SPacket::toBytes)
				.consumerMainThread(GainEffectFromEatingC2SPacket::handle)
				.add();
		 net.messageBuilder(HunterDropsMeatC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(HunterDropsMeatC2SPacket::new)
				.encoder(HunterDropsMeatC2SPacket::toBytes)
				.consumerMainThread(HunterDropsMeatC2SPacket::handle)
				.add();
		 net.messageBuilder(SpawnArrowOnPlayerC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpawnArrowOnPlayerC2SPacket::new)
				.encoder(SpawnArrowOnPlayerC2SPacket::toBytes)
				.consumerMainThread(SpawnArrowOnPlayerC2SPacket::handle)
				.add();
		 net.messageBuilder(HealFromRottenFleshTotalC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(HealFromRottenFleshTotalC2SPacket::new)
				.encoder(HealFromRottenFleshTotalC2SPacket::toBytes)
				.consumerMainThread(HealFromRottenFleshTotalC2SPacket::handle)
				.add();
		 net.messageBuilder(SpawnTamedBeeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpawnTamedBeeC2SPacket::new)
				.encoder(SpawnTamedBeeC2SPacket::toBytes)
				.consumerMainThread(SpawnTamedBeeC2SPacket::handle)
				.add();
		net.messageBuilder(SpawnTamedFrogC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpawnTamedFrogC2SPacket::new)
				.encoder(SpawnTamedFrogC2SPacket::toBytes)
				.consumerMainThread(SpawnTamedFrogC2SPacket::handle)
				.add();
			
//-----------C2S--Skills---------------------------------------------------------------------------------
		 net.messageBuilder(GainPlayerLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainPlayerLevelC2SPacket::new)
				.encoder(GainPlayerLevelC2SPacket::toBytes)
				.consumerMainThread(GainPlayerLevelC2SPacket::handle)
				.add();
		 net.messageBuilder(GainPlayerLevelExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainPlayerLevelExpC2SPacket::new)
				.encoder(GainPlayerLevelExpC2SPacket::toBytes)
				.consumerMainThread(GainPlayerLevelExpC2SPacket::handle)
				.add();
		 net.messageBuilder(GainPlayerUpgradePointsC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainPlayerUpgradePointsC2SPacket::new)
				.encoder(GainPlayerUpgradePointsC2SPacket::toBytes)
				.consumerMainThread(GainPlayerUpgradePointsC2SPacket::handle)
				.add();
		 net.messageBuilder(SpendPlayerUpgradePointsC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpendPlayerUpgradePointsC2SPacket::new)
				.encoder(SpendPlayerUpgradePointsC2SPacket::toBytes)
				.consumerMainThread(SpendPlayerUpgradePointsC2SPacket::handle)
				.add();
		 net.messageBuilder(ResetPlayerLevelExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetPlayerLevelExpC2SPacket::new)
				.encoder(ResetPlayerLevelExpC2SPacket::toBytes)
				.consumerMainThread(ResetPlayerLevelExpC2SPacket::handle)
				.add();
        net.messageBuilder(ResetMiningExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetMiningExpC2SPacket::new)
				.encoder(ResetMiningExpC2SPacket::toBytes)
				.consumerMainThread(ResetMiningExpC2SPacket::handle)
				.add();
        net.messageBuilder(ResetArcheryExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetArcheryExpC2SPacket::new)
				.encoder(ResetArcheryExpC2SPacket::toBytes)
				.consumerMainThread(ResetArcheryExpC2SPacket::handle)
				.add();
        net.messageBuilder(ResetChoppingExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetChoppingExpC2SPacket::new)
				.encoder(ResetChoppingExpC2SPacket::toBytes)
				.consumerMainThread(ResetChoppingExpC2SPacket::handle)
				.add();
        net.messageBuilder(ResetCombatExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetCombatExpC2SPacket::new)
				.encoder(ResetCombatExpC2SPacket::toBytes)
				.consumerMainThread(ResetCombatExpC2SPacket::handle)
				.add();
        net.messageBuilder(ResetFarmingExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetFarmingExpC2SPacket::new)
				.encoder(ResetFarmingExpC2SPacket::toBytes)
				.consumerMainThread(ResetFarmingExpC2SPacket::handle)
				.add();
        net.messageBuilder(ResetSwordsExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetSwordsExpC2SPacket::new)
				.encoder(ResetSwordsExpC2SPacket::toBytes)
				.consumerMainThread(ResetSwordsExpC2SPacket::handle)
				.add();
        net.messageBuilder(ResetCapabilityDataC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ResetCapabilityDataC2SPacket::new)
				.encoder(ResetCapabilityDataC2SPacket::toBytes)
				.consumerMainThread(ResetCapabilityDataC2SPacket::handle)
				.add();
        net.messageBuilder(GainMiningLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainMiningLevelC2SPacket::new)
				.encoder(GainMiningLevelC2SPacket::toBytes)
				.consumerMainThread(GainMiningLevelC2SPacket::handle)
				.add();
        net.messageBuilder(GainMiningExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
        		.decoder(GainMiningExpC2SPacket::new)
        		.encoder(GainMiningExpC2SPacket::toBytes)
        		.consumerMainThread(GainMiningExpC2SPacket::handle)
        		.add();
        net.messageBuilder(GainArcheryLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainArcheryLevelC2SPacket::new)
				.encoder(GainArcheryLevelC2SPacket::toBytes)
				.consumerMainThread(GainArcheryLevelC2SPacket::handle)
				.add();
        net.messageBuilder(GainArcheryExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainArcheryExpC2SPacket::new)
				.encoder(GainArcheryExpC2SPacket::toBytes)
				.consumerMainThread(GainArcheryExpC2SPacket::handle)
				.add();
        net.messageBuilder(GainChoppingLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainChoppingLevelC2SPacket::new)
				.encoder(GainChoppingLevelC2SPacket::toBytes)
				.consumerMainThread(GainChoppingLevelC2SPacket::handle)
				.add();
        net.messageBuilder(GainChoppingExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainChoppingExpC2SPacket::new)
				.encoder(GainChoppingExpC2SPacket::toBytes)
				.consumerMainThread(GainChoppingExpC2SPacket::handle)
				.add();
        net.messageBuilder(GainCombatLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainCombatLevelC2SPacket::new)
				.encoder(GainCombatLevelC2SPacket::toBytes)
				.consumerMainThread(GainCombatLevelC2SPacket::handle)
				.add();
        net.messageBuilder(GainCombatExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainCombatExpC2SPacket::new)
				.encoder(GainCombatExpC2SPacket::toBytes)
				.consumerMainThread(GainCombatExpC2SPacket::handle)
				.add();
        net.messageBuilder(GainFarmingLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainFarmingLevelC2SPacket::new)
				.encoder(GainFarmingLevelC2SPacket::toBytes)
				.consumerMainThread(GainFarmingLevelC2SPacket::handle)
				.add();
        net.messageBuilder(GainFarmingExpFromUnseededCropsC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainFarmingExpFromUnseededCropsC2SPacket::new)
				.encoder(GainFarmingExpFromUnseededCropsC2SPacket::toBytes)
				.consumerMainThread(GainFarmingExpFromUnseededCropsC2SPacket::handle)
				.add();
        net.messageBuilder(GainFarmingExpFromSeededCropsC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainFarmingExpFromSeededCropsC2SPacket::new)
				.encoder(GainFarmingExpFromSeededCropsC2SPacket::toBytes)
				.consumerMainThread(GainFarmingExpFromSeededCropsC2SPacket::handle)
				.add();
        net.messageBuilder(GainSwordsLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainSwordsLevelC2SPacket::new)
				.encoder(GainSwordsLevelC2SPacket::toBytes)
				.consumerMainThread(GainSwordsLevelC2SPacket::handle)
				.add();
        net.messageBuilder(GainSwordsExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainSwordsExpC2SPacket::new)
				.encoder(GainSwordsExpC2SPacket::toBytes)
				.consumerMainThread(GainSwordsExpC2SPacket::handle)
				.add();
        net.messageBuilder(GainNightVisionC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(GainNightVisionC2SPacket::new)
                .encoder(GainNightVisionC2SPacket::toBytes)
                .consumerMainThread(GainNightVisionC2SPacket::handle)
                .add();
		net.messageBuilder(GainMagicLevelC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainMagicLevelC2SPacket::new)
				.encoder(GainMagicLevelC2SPacket::toBytes)
				.consumerMainThread(GainMagicLevelC2SPacket::handle)
				.add();
		net.messageBuilder(GainMagicExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GainMagicExpC2SPacket::new)
				.encoder(GainMagicExpC2SPacket::toBytes)
				.consumerMainThread(GainMagicExpC2SPacket::handle)
				.add();

//--------------S2C--Skills----------------------------------------------------
		net.messageBuilder(PlayerLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        		.decoder(PlayerLevelDataSyncS2CPacket::new)
        		.encoder(PlayerLevelDataSyncS2CPacket::toBytes)
        		.consumerMainThread(PlayerLevelDataSyncS2CPacket::handle)
        		.add();
		net.messageBuilder(PlayerLevelExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        		.decoder(PlayerLevelExpDataSyncS2CPacket::new)
        		.encoder(PlayerLevelExpDataSyncS2CPacket::toBytes)
        		.consumerMainThread(PlayerLevelExpDataSyncS2CPacket::handle)
        		.add();
		net.messageBuilder(PlayerUpgradePointsDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(PlayerUpgradePointsDataSyncS2CPacket::new)
				.encoder(PlayerUpgradePointsDataSyncS2CPacket::toBytes)
				.consumerMainThread(PlayerUpgradePointsDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(ManaDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ManaDataSyncS2CPacket::new)
                .encoder(ManaDataSyncS2CPacket::toBytes)
                .consumerMainThread(ManaDataSyncS2CPacket::handle)
                .add();
        net.messageBuilder(MiningLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        		.decoder(MiningLevelDataSyncS2CPacket::new)
        		.encoder(MiningLevelDataSyncS2CPacket::toBytes)
        		.consumerMainThread(MiningLevelDataSyncS2CPacket::handle)
        		.add();
        net.messageBuilder(MiningExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
        		.decoder(MiningExpDataSyncS2CPacket::new)
        		.encoder(MiningExpDataSyncS2CPacket::toBytes)
        		.consumerMainThread(MiningExpDataSyncS2CPacket::handle)
        		.add();
        net.messageBuilder(ArcheryLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ArcheryLevelDataSyncS2CPacket::new)
				.encoder(ArcheryLevelDataSyncS2CPacket::toBytes)
				.consumerMainThread(ArcheryLevelDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(ArcheryExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ArcheryExpDataSyncS2CPacket::new)
				.encoder(ArcheryExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(ArcheryExpDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(ChoppingLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ChoppingLevelDataSyncS2CPacket::new)
				.encoder(ChoppingLevelDataSyncS2CPacket::toBytes)
				.consumerMainThread(ChoppingLevelDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(ChoppingExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ChoppingExpDataSyncS2CPacket::new)
				.encoder(ChoppingExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(ChoppingExpDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(CombatLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CombatLevelDataSyncS2CPacket::new)
				.encoder(CombatLevelDataSyncS2CPacket::toBytes)
				.consumerMainThread(CombatLevelDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(CombatExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CombatExpDataSyncS2CPacket::new)
				.encoder(CombatExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(CombatExpDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(FarmingLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(FarmingLevelDataSyncS2CPacket::new)
				.encoder(FarmingLevelDataSyncS2CPacket::toBytes)
				.consumerMainThread(FarmingLevelDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(FarmingExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(FarmingExpDataSyncS2CPacket::new)
				.encoder(FarmingExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(FarmingExpDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SwordsLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SwordsLevelDataSyncS2CPacket::new)
				.encoder(SwordsLevelDataSyncS2CPacket::toBytes)
				.consumerMainThread(SwordsLevelDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SwordsExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SwordsExpDataSyncS2CPacket::new)
				.encoder(SwordsExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(SwordsExpDataSyncS2CPacket::handle)
				.add();
		net.messageBuilder(MagicLevelDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(MagicLevelDataSyncS2CPacket::new)
				.encoder(MagicLevelDataSyncS2CPacket::toBytes)
				.consumerMainThread(MagicLevelDataSyncS2CPacket::handle)
				.add();
		net.messageBuilder(MagicExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(MagicExpDataSyncS2CPacket::new)
				.encoder(MagicExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(MagicExpDataSyncS2CPacket::handle)
				.add();
//-------------Upgrades---C2S--------------------------------------------
        //Archery
        net.messageBuilder(EfficientMarksmanUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(EfficientMarksmanUpgradeC2SPacket::new)
				.encoder(EfficientMarksmanUpgradeC2SPacket::toBytes)
				.consumerMainThread(EfficientMarksmanUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(HunterUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(HunterUpgradeC2SPacket::new)
				.encoder(HunterUpgradeC2SPacket::toBytes)
				.consumerMainThread(HunterUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(InsecurityUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(InsecurityUpgradeC2SPacket::new)
				.encoder(InsecurityUpgradeC2SPacket::toBytes)
				.consumerMainThread(InsecurityUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(LeftClickUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(LeftClickUpgradeC2SPacket::new)
				.encoder(LeftClickUpgradeC2SPacket::toBytes)
				.consumerMainThread(LeftClickUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(QuickshotUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(QuickshotUpgradeC2SPacket::new)
				.encoder(QuickshotUpgradeC2SPacket::toBytes)
				.consumerMainThread(QuickshotUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(SharpshooterUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SharpshooterUpgradeC2SPacket::new)
				.encoder(SharpshooterUpgradeC2SPacket::toBytes)
				.consumerMainThread(SharpshooterUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(SniperUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SniperUpgradeC2SPacket::new)
				.encoder(SniperUpgradeC2SPacket::toBytes)
				.consumerMainThread(SniperUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(SweetSpotArcheryUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SweetSpotArcheryUpgradeC2SPacket::new)
				.encoder(SweetSpotArcheryUpgradeC2SPacket::toBytes)
				.consumerMainThread(SweetSpotArcheryUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(UnabatedUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UnabatedUpgradeC2SPacket::new)
				.encoder(UnabatedUpgradeC2SPacket::toBytes)
				.consumerMainThread(UnabatedUpgradeC2SPacket::handle)
				.add();
        
        //Chopping
        net.messageBuilder(GrannySmithUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GrannySmithUpgradeC2SPacket::new)
				.encoder(GrannySmithUpgradeC2SPacket::toBytes)
				.consumerMainThread(GrannySmithUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(HardwoodUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(HardwoodUpgradeC2SPacket::new)
				.encoder(HardwoodUpgradeC2SPacket::toBytes)
				.consumerMainThread(HardwoodUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(HighGroundUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(HighGroundUpgradeC2SPacket::new)
				.encoder(HighGroundUpgradeC2SPacket::toBytes)
				.consumerMainThread(HighGroundUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(StrongArmsUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(StrongArmsUpgradeC2SPacket::new)
				.encoder(StrongArmsUpgradeC2SPacket::toBytes)
				.consumerMainThread(StrongArmsUpgradeC2SPacket::handle)
				.add();
        
        //Combat
        net.messageBuilder(DodgeRollUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(DodgeRollUpgradeC2SPacket::new)
				.encoder(DodgeRollUpgradeC2SPacket::toBytes)
				.consumerMainThread(DodgeRollUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(FreeArrowsUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(FreeArrowsUpgradeC2SPacket::new)
				.encoder(FreeArrowsUpgradeC2SPacket::toBytes)
				.consumerMainThread(FreeArrowsUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(OvercomeUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(OvercomeUpgradeC2SPacket::new)
				.encoder(OvercomeUpgradeC2SPacket::toBytes)
				.consumerMainThread(OvercomeUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(RagnorokUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(RagnorokUpgradeC2SPacket::new)
				.encoder(RagnorokUpgradeC2SPacket::toBytes)
				.consumerMainThread(RagnorokUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(StableFootingUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(StableFootingUpgradeC2SPacket::new)
				.encoder(StableFootingUpgradeC2SPacket::toBytes)
				.consumerMainThread(StableFootingUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(TakeStanceUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(TakeStanceUpgradeC2SPacket::new)
				.encoder(TakeStanceUpgradeC2SPacket::toBytes)
				.consumerMainThread(TakeStanceUpgradeC2SPacket::handle)
				.add();
        
        //Farming
        net.messageBuilder(CarnivoreUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CarnivoreUpgradeC2SPacket::new)
				.encoder(CarnivoreUpgradeC2SPacket::toBytes)
				.consumerMainThread(CarnivoreUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(EggerUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(EggerUpgradeC2SPacket::new)
				.encoder(EggerUpgradeC2SPacket::toBytes)
				.consumerMainThread(EggerUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(SugarRushUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SugarRushUpgradeC2SPacket::new)
				.encoder(SugarRushUpgradeC2SPacket::toBytes)
				.consumerMainThread(SugarRushUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(WellFedUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(WellFedUpgradeC2SPacket::new)
				.encoder(WellFedUpgradeC2SPacket::toBytes)
				.consumerMainThread(WellFedUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(FastFoodUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(FastFoodUpgradeC2SPacket::new)
				.encoder(FastFoodUpgradeC2SPacket::toBytes)
				.consumerMainThread(FastFoodUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(InsatiableUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(InsatiableUpgradeC2SPacket::new)
				.encoder(InsatiableUpgradeC2SPacket::toBytes)
				.consumerMainThread(InsatiableUpgradeC2SPacket::handle)
				.add();
        //Mining
        net.messageBuilder(UpgradeJunkBlocksDropExpC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeJunkBlocksDropExpC2SPacket::new)
				.encoder(UpgradeJunkBlocksDropExpC2SPacket::toBytes)
				.consumerMainThread(UpgradeJunkBlocksDropExpC2SPacket::handle)
				.add();
        net.messageBuilder(UpgradeNightVisionC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeNightVisionC2SPacket::new)
				.encoder(UpgradeNightVisionC2SPacket::toBytes)
				.consumerMainThread(UpgradeNightVisionC2SPacket::handle)
				.add();
        net.messageBuilder(UpgradeNoJunkBlocksC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeNoJunkBlocksC2SPacket::new)
				.encoder(UpgradeNoJunkBlocksC2SPacket::toBytes)
				.consumerMainThread(UpgradeNoJunkBlocksC2SPacket::handle)
				.add();
        net.messageBuilder(UpgradeObsidianBreakerC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(UpgradeObsidianBreakerC2SPacket::new)
				.encoder(UpgradeObsidianBreakerC2SPacket::toBytes)
				.consumerMainThread(UpgradeObsidianBreakerC2SPacket::handle)
				.add();
        
        //Swords
        net.messageBuilder(CritasticUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CritasticUpgradeC2SPacket::new)
				.encoder(CritasticUpgradeC2SPacket::toBytes)
				.consumerMainThread(CritasticUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(FleshWoundUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(FleshWoundUpgradeC2SPacket::new)
				.encoder(FleshWoundUpgradeC2SPacket::toBytes)
				.consumerMainThread(FleshWoundUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(PerfectTimingUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(PerfectTimingUpgradeC2SPacket::new)
				.encoder(PerfectTimingUpgradeC2SPacket::toBytes)
				.consumerMainThread(PerfectTimingUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(RightClickUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(RightClickUpgradeC2SPacket::new)
				.encoder(RightClickUpgradeC2SPacket::toBytes)
				.consumerMainThread(RightClickUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(ShieldBashUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ShieldBashUpgradeC2SPacket::new)
				.encoder(ShieldBashUpgradeC2SPacket::toBytes)
				.consumerMainThread(ShieldBashUpgradeC2SPacket::handle)
				.add();
        net.messageBuilder(SweetSpotSwordsUpgradeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SweetSpotSwordsUpgradeC2SPacket::new)
				.encoder(SweetSpotSwordsUpgradeC2SPacket::toBytes)
				.consumerMainThread(SweetSpotSwordsUpgradeC2SPacket::handle)
				.add();


//-------------Upgrades---S2C---------------------------------------------------------------------------------------
        //Archery
        net.messageBuilder(EfficientMarksmanUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(EfficientMarksmanUpgradeDataSyncS2CPacket::new)
				.encoder(EfficientMarksmanUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(EfficientMarksmanUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(HunterUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(HunterUpgradeDataSyncS2CPacket::new)
				.encoder(HunterUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(HunterUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(InsecurityUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(InsecurityUpgradeDataSyncS2CPacket::new)
				.encoder(InsecurityUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(InsecurityUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(LeftClickUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(LeftClickUpgradeDataSyncS2CPacket::new)
				.encoder(LeftClickUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(LeftClickUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(QuickshotUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(QuickshotUpgradeDataSyncS2CPacket::new)
				.encoder(QuickshotUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(QuickshotUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SharpshooterUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SharpshooterUpgradeDataSyncS2CPacket::new)
				.encoder(SharpshooterUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(SharpshooterUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SniperUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SniperUpgradeDataSyncS2CPacket::new)
				.encoder(SniperUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(SniperUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SweetSpotArcheryUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SweetSpotArcheryUpgradeDataSyncS2CPacket::new)
				.encoder(SweetSpotArcheryUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(SweetSpotArcheryUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(UnabatedUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(UnabatedUpgradeDataSyncS2CPacket::new)
				.encoder(UnabatedUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(UnabatedUpgradeDataSyncS2CPacket::handle)
				.add();
        //Chopping
        net.messageBuilder(GrannySmithUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(GrannySmithUpgradeDataSyncS2CPacket::new)
				.encoder(GrannySmithUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(GrannySmithUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(HardwoodUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(HardwoodUpgradeDataSyncS2CPacket::new)
				.encoder(HardwoodUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(HardwoodUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(HighGroundUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(HighGroundUpgradeDataSyncS2CPacket::new)
				.encoder(HighGroundUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(HighGroundUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(StrongArmsUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(StrongArmsUpgradeDataSyncS2CPacket::new)
				.encoder(StrongArmsUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(StrongArmsUpgradeDataSyncS2CPacket::handle)
				.add();
        //Combat
        net.messageBuilder(DodgeRollUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(DodgeRollUpgradeDataSyncS2CPacket::new)
				.encoder(DodgeRollUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(DodgeRollUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(FreeArrowsUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(FreeArrowsUpgradeDataSyncS2CPacket::new)
				.encoder(FreeArrowsUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(FreeArrowsUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(OvercomeUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(OvercomeUpgradeDataSyncS2CPacket::new)
				.encoder(OvercomeUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(OvercomeUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(RagnorokUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(RagnorokUpgradeDataSyncS2CPacket::new)
				.encoder(RagnorokUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(RagnorokUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(StableFootingUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(StableFootingUpgradeDataSyncS2CPacket::new)
				.encoder(StableFootingUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(StableFootingUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(TakeStanceUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(TakeStanceUpgradeDataSyncS2CPacket::new)
				.encoder(TakeStanceUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(TakeStanceUpgradeDataSyncS2CPacket::handle)
				.add();
        //Farming
        net.messageBuilder(CarnivoreUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CarnivoreUpgradeDataSyncS2CPacket::new)
				.encoder(CarnivoreUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(CarnivoreUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(EggerUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(EggerUpgradeDataSyncS2CPacket::new)
				.encoder(EggerUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(EggerUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SugarRushUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SugarRushUpgradeDataSyncS2CPacket::new)
				.encoder(SugarRushUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(SugarRushUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(FastFoodUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(FastFoodUpgradeDataSyncS2CPacket::new)
				.encoder(FastFoodUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(FastFoodUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(InsatiableUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(InsatiableUpgradeDataSyncS2CPacket::new)
				.encoder(InsatiableUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(InsatiableUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(WellFedUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(WellFedUpgradeDataSyncS2CPacket::new)
				.encoder(WellFedUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(WellFedUpgradeDataSyncS2CPacket::handle)
				.add();
        //Mining
        net.messageBuilder(JunkBlocksDropExpDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(JunkBlocksDropExpDataSyncS2CPacket::new)
				.encoder(JunkBlocksDropExpDataSyncS2CPacket::toBytes)
				.consumerMainThread(JunkBlocksDropExpDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(NightVisionDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(NightVisionDataSyncS2CPacket::new)
				.encoder(NightVisionDataSyncS2CPacket::toBytes)
				.consumerMainThread(NightVisionDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(NoJunkBlocksDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(NoJunkBlocksDataSyncS2CPacket::new)
				.encoder(NoJunkBlocksDataSyncS2CPacket::toBytes)
				.consumerMainThread(NoJunkBlocksDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(ObsidianBreakerDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ObsidianBreakerDataSyncS2CPacket::new)
				.encoder(ObsidianBreakerDataSyncS2CPacket::toBytes)
				.consumerMainThread(ObsidianBreakerDataSyncS2CPacket::handle)
				.add();
        //Swords
        net.messageBuilder(CritasticUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CritasticUpgradeDataSyncS2CPacket::new)
				.encoder(CritasticUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(CritasticUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(FleshWoundUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(FleshWoundUpgradeDataSyncS2CPacket::new)
				.encoder(FleshWoundUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(FleshWoundUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(PerfectTimingUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(PerfectTimingUpgradeDataSyncS2CPacket::new)
				.encoder(PerfectTimingUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(PerfectTimingUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(RightClickUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(RightClickUpgradeDataSyncS2CPacket::new)
				.encoder(RightClickUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(RightClickUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(ShieldBashUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ShieldBashUpgradeDataSyncS2CPacket::new)
				.encoder(ShieldBashUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(ShieldBashUpgradeDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SweetSpotSwordsUpgradeDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SweetSpotSwordsUpgradeDataSyncS2CPacket::new)
				.encoder(SweetSpotSwordsUpgradeDataSyncS2CPacket::toBytes)
				.consumerMainThread(SweetSpotSwordsUpgradeDataSyncS2CPacket::handle)
				.add();
//---------------Blocks Mined C2S-----------------------------------------------
        net.messageBuilder(AncientDebrisMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(AncientDebrisMinedC2SPacket::new)
				.encoder(AncientDebrisMinedC2SPacket::toBytes)
				.consumerMainThread(AncientDebrisMinedC2SPacket::handle)
				.add();
        net.messageBuilder(CoalMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CoalMinedC2SPacket::new)
				.encoder(CoalMinedC2SPacket::toBytes)
				.consumerMainThread(CoalMinedC2SPacket::handle)
				.add();
        net.messageBuilder(CopperMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CopperMinedC2SPacket::new)
				.encoder(CopperMinedC2SPacket::toBytes)
				.consumerMainThread(CopperMinedC2SPacket::handle)
				.add();
        net.messageBuilder(DiamondMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(DiamondMinedC2SPacket::new)
				.encoder(DiamondMinedC2SPacket::toBytes)
				.consumerMainThread(DiamondMinedC2SPacket::handle)
				.add();
        net.messageBuilder(EmeraldMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(EmeraldMinedC2SPacket::new)
				.encoder(EmeraldMinedC2SPacket::toBytes)
				.consumerMainThread(EmeraldMinedC2SPacket::handle)
				.add();
        net.messageBuilder(GlowstoneMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GlowstoneMinedC2SPacket::new)
				.encoder(GlowstoneMinedC2SPacket::toBytes)
				.consumerMainThread(GlowstoneMinedC2SPacket::handle)
				.add();
        net.messageBuilder(GoldMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
        		.decoder(GoldMinedC2SPacket::new)
        		.encoder(GoldMinedC2SPacket::toBytes)
        		.consumerMainThread(GoldMinedC2SPacket::handle)
        		.add();
        net.messageBuilder(IronMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(IronMinedC2SPacket::new)
				.encoder(IronMinedC2SPacket::toBytes)
				.consumerMainThread(IronMinedC2SPacket::handle)
				.add();
        net.messageBuilder(LapisMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(LapisMinedC2SPacket::new)
				.encoder(LapisMinedC2SPacket::toBytes)
				.consumerMainThread(LapisMinedC2SPacket::handle)
				.add();
        net.messageBuilder(NetherGoldMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(NetherGoldMinedC2SPacket::new)
				.encoder(NetherGoldMinedC2SPacket::toBytes)
				.consumerMainThread(NetherGoldMinedC2SPacket::handle)
				.add();
        net.messageBuilder(QuartzMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(QuartzMinedC2SPacket::new)
				.encoder(QuartzMinedC2SPacket::toBytes)
				.consumerMainThread(QuartzMinedC2SPacket::handle)
				.add();
        net.messageBuilder(RedstoneMinedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(RedstoneMinedC2SPacket::new)
				.encoder(RedstoneMinedC2SPacket::toBytes)
				.consumerMainThread(RedstoneMinedC2SPacket::handle)
				.add();
//-------------Blocks Mined S2C---------------------------------
        net.messageBuilder(AncientDebrisMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(AncientDebrisMinedDataSyncS2CPacket::new)
				.encoder(AncientDebrisMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(AncientDebrisMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(CoalMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CoalMinedDataSyncS2CPacket::new)
				.encoder(CoalMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(CoalMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(CopperMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CopperMinedDataSyncS2CPacket::new)
				.encoder(CopperMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(CopperMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(DiamondMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(DiamondMinedDataSyncS2CPacket::new)
				.encoder(DiamondMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(DiamondMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(EmeraldMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(EmeraldMinedDataSyncS2CPacket::new)
				.encoder(EmeraldMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(EmeraldMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(GlowstoneMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(GlowstoneMinedDataSyncS2CPacket::new)
				.encoder(GlowstoneMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(GlowstoneMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(GoldMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(GoldMinedDataSyncS2CPacket::new)
				.encoder(GoldMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(GoldMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(IronMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(IronMinedDataSyncS2CPacket::new)
				.encoder(IronMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(IronMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(LapisMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(LapisMinedDataSyncS2CPacket::new)
				.encoder(LapisMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(LapisMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(NetherGoldMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(NetherGoldMinedDataSyncS2CPacket::new)
				.encoder(NetherGoldMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(NetherGoldMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(QuartzMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(QuartzMinedDataSyncS2CPacket::new)
				.encoder(QuartzMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(QuartzMinedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(RedstoneMinedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(RedstoneMinedDataSyncS2CPacket::new)
				.encoder(RedstoneMinedDataSyncS2CPacket::toBytes)
				.consumerMainThread(RedstoneMinedDataSyncS2CPacket::handle)
				.add();
//Foods--Eaten-----C2S--------------------------------
        net.messageBuilder(ApplesEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ApplesEatenC2SPacket::new)
				.encoder(ApplesEatenC2SPacket::toBytes)
				.consumerMainThread(ApplesEatenC2SPacket::handle)
				.add();
        net.messageBuilder(BeefEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(BeefEatenC2SPacket::new)
				.encoder(BeefEatenC2SPacket::toBytes)
				.consumerMainThread(BeefEatenC2SPacket::handle)
				.add();
        net.messageBuilder(BeetrootEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(BeetrootEatenC2SPacket::new)
				.encoder(BeetrootEatenC2SPacket::toBytes)
				.consumerMainThread(BeetrootEatenC2SPacket::handle)
				.add();
        net.messageBuilder(BreadEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(BreadEatenC2SPacket::new)
				.encoder(BreadEatenC2SPacket::toBytes)
				.consumerMainThread(BreadEatenC2SPacket::handle)
				.add();
        net.messageBuilder(CakeEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CakeEatenC2SPacket::new)
				.encoder(CakeEatenC2SPacket::toBytes)
				.consumerMainThread(CakeEatenC2SPacket::handle)
				.add();
        net.messageBuilder(CarrotsEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CarrotsEatenC2SPacket::new)
				.encoder(CarrotsEatenC2SPacket::toBytes)
				.consumerMainThread(CarrotsEatenC2SPacket::handle)
				.add();
        net.messageBuilder(ChickenEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(ChickenEatenC2SPacket::new)
				.encoder(ChickenEatenC2SPacket::toBytes)
				.consumerMainThread(ChickenEatenC2SPacket::handle)
				.add();
        net.messageBuilder(CookiesEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CookiesEatenC2SPacket::new)
				.encoder(CookiesEatenC2SPacket::toBytes)
				.consumerMainThread(CookiesEatenC2SPacket::handle)
				.add();
        net.messageBuilder(FishEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(FishEatenC2SPacket::new)
				.encoder(FishEatenC2SPacket::toBytes)
				.consumerMainThread(FishEatenC2SPacket::handle)
				.add();
        net.messageBuilder(GlowBerriesEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GlowBerriesEatenC2SPacket::new)
				.encoder(GlowBerriesEatenC2SPacket::toBytes)
				.consumerMainThread(GlowBerriesEatenC2SPacket::handle)
				.add();
        net.messageBuilder(GoldApplesEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GoldApplesEatenC2SPacket::new)
				.encoder(GoldApplesEatenC2SPacket::toBytes)
				.consumerMainThread(GoldApplesEatenC2SPacket::handle)
				.add();
        net.messageBuilder(GoldenCarrotsEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(GoldenCarrotsEatenC2SPacket::new)
				.encoder(GoldenCarrotsEatenC2SPacket::toBytes)
				.consumerMainThread(GoldenCarrotsEatenC2SPacket::handle)
				.add();
        net.messageBuilder(HoneyEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(HoneyEatenC2SPacket::new)
				.encoder(HoneyEatenC2SPacket::toBytes)
				.consumerMainThread(HoneyEatenC2SPacket::handle)
				.add();
        net.messageBuilder(KelpEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(KelpEatenC2SPacket::new)
				.encoder(KelpEatenC2SPacket::toBytes)
				.consumerMainThread(KelpEatenC2SPacket::handle)
				.add();
        net.messageBuilder(MelonEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(MelonEatenC2SPacket::new)
				.encoder(MelonEatenC2SPacket::toBytes)
				.consumerMainThread(MelonEatenC2SPacket::handle)
				.add();
        net.messageBuilder(MushroomStewEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(MushroomStewEatenC2SPacket::new)
				.encoder(MushroomStewEatenC2SPacket::toBytes)
				.consumerMainThread(MushroomStewEatenC2SPacket::handle)
				.add();
        net.messageBuilder(MuttonEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(MuttonEatenC2SPacket::new)
				.encoder(MuttonEatenC2SPacket::toBytes)
				.consumerMainThread(MuttonEatenC2SPacket::handle)
				.add();
        net.messageBuilder(PoisonousPotatoEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(PoisonousPotatoEatenC2SPacket::new)
				.encoder(PoisonousPotatoEatenC2SPacket::toBytes)
				.consumerMainThread(PoisonousPotatoEatenC2SPacket::handle)
				.add();
        net.messageBuilder(PorkEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(PorkEatenC2SPacket::new)
				.encoder(PorkEatenC2SPacket::toBytes)
				.consumerMainThread(PorkEatenC2SPacket::handle)
				.add();
        net.messageBuilder(PotatoEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(PotatoEatenC2SPacket::new)
				.encoder(PotatoEatenC2SPacket::toBytes)
				.consumerMainThread(PotatoEatenC2SPacket::handle)
				.add();
        net.messageBuilder(PufferfishEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(PufferfishEatenC2SPacket::new)
				.encoder(PufferfishEatenC2SPacket::toBytes)
				.consumerMainThread(PufferfishEatenC2SPacket::handle)
				.add();
        net.messageBuilder(PumpkinPieEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(PumpkinPieEatenC2SPacket::new)
				.encoder(PumpkinPieEatenC2SPacket::toBytes)
				.consumerMainThread(PumpkinPieEatenC2SPacket::handle)
				.add();
        net.messageBuilder(RabbitEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(RabbitEatenC2SPacket::new)
				.encoder(RabbitEatenC2SPacket::toBytes)
				.consumerMainThread(RabbitEatenC2SPacket::handle)
				.add();
        net.messageBuilder(RawFoodEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(RawFoodEatenC2SPacket::new)
				.encoder(RawFoodEatenC2SPacket::toBytes)
				.consumerMainThread(RawFoodEatenC2SPacket::handle)
				.add();
        net.messageBuilder(RottenFleshEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(RottenFleshEatenC2SPacket::new)
				.encoder(RottenFleshEatenC2SPacket::toBytes)
				.consumerMainThread(RottenFleshEatenC2SPacket::handle)
				.add();
        net.messageBuilder(SpiderEyeEatenC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpiderEyeEatenC2SPacket::new)
				.encoder(SpiderEyeEatenC2SPacket::toBytes)
				.consumerMainThread(SpiderEyeEatenC2SPacket::handle)
				.add();
        
//Foods--Eaten-----S2C--------------------------------
        net.messageBuilder(ApplesEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(ApplesEatenDataSyncS2CPacket::new)
				.encoder(ApplesEatenDataSyncS2CPacket::toBytes)
				.consumerMainThread(ApplesEatenDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(BeefEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(BeefEatenDataSyncS2CPacket::new)
	 			.encoder(BeefEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(BeefEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(BeetrootEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(BeetrootEatenDataSyncS2CPacket::new)
	 			.encoder(BeetrootEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(BeetrootEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(BreadEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(BreadEatenDataSyncS2CPacket::new)
	 			.encoder(BreadEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(BreadEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(CakeEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(CakeEatenDataSyncS2CPacket::new)
	 			.encoder(CakeEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(CakeEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(CarrotsEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(CarrotsEatenDataSyncS2CPacket::new)
	 			.encoder(CarrotsEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(CarrotsEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(ChickenEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(ChickenEatenDataSyncS2CPacket::new)
	 			.encoder(ChickenEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(ChickenEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(CookiesEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(CookiesEatenDataSyncS2CPacket::new)
	 			.encoder(CookiesEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(CookiesEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(FishEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(FishEatenDataSyncS2CPacket::new)
	 			.encoder(FishEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(FishEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(GlowBerriesEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(GlowBerriesEatenDataSyncS2CPacket::new)
	 			.encoder(GlowBerriesEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(GlowBerriesEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(GoldApplesEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(GoldApplesEatenDataSyncS2CPacket::new)
	 			.encoder(GoldApplesEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(GoldApplesEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(GoldenCarrotsEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(GoldenCarrotsEatenDataSyncS2CPacket::new)
	 			.encoder(GoldenCarrotsEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(GoldenCarrotsEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(HoneyEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(HoneyEatenDataSyncS2CPacket::new)
	 			.encoder(HoneyEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(HoneyEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(KelpEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(KelpEatenDataSyncS2CPacket::new)
	 			.encoder(KelpEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(KelpEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(MelonEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(MelonEatenDataSyncS2CPacket::new)
	 			.encoder(MelonEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(MelonEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(MushroomStewEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(MushroomStewEatenDataSyncS2CPacket::new)
	 			.encoder(MushroomStewEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(MushroomStewEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(MuttonEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(MuttonEatenDataSyncS2CPacket::new)
	 			.encoder(MuttonEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(MuttonEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(PoisonousPotatoEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(PoisonousPotatoEatenDataSyncS2CPacket::new)
	 			.encoder(PoisonousPotatoEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(PoisonousPotatoEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(PorkEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(PorkEatenDataSyncS2CPacket::new)
	 			.encoder(PorkEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(PorkEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(PotatoEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(PotatoEatenDataSyncS2CPacket::new)
	 			.encoder(PotatoEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(PotatoEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(PufferfishEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(PufferfishEatenDataSyncS2CPacket::new)
	 			.encoder(PufferfishEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(PufferfishEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(PumpkinPieEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(PumpkinPieEatenDataSyncS2CPacket::new)
	 			.encoder(PumpkinPieEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(PumpkinPieEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(RabbitEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(RabbitEatenDataSyncS2CPacket::new)
	 			.encoder(RabbitEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(RabbitEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(RawFoodEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(RawFoodEatenDataSyncS2CPacket::new)
	 			.encoder(RawFoodEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(RawFoodEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(RottenFleshEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(RottenFleshEatenDataSyncS2CPacket::new)
	 			.encoder(RottenFleshEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(RottenFleshEatenDataSyncS2CPacket::handle)
	 			.add();
        net.messageBuilder(SpiderEyeEatenDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
	 			.decoder(SpiderEyeEatenDataSyncS2CPacket::new)
	 			.encoder(SpiderEyeEatenDataSyncS2CPacket::toBytes)
	 			.consumerMainThread(SpiderEyeEatenDataSyncS2CPacket::handle)
	 			.add();
        
        //Logs--Chopped-----C2S------------------
        net.messageBuilder(AcaciaChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(AcaciaChoppedC2SPacket::new)
				.encoder(AcaciaChoppedC2SPacket::toBytes)
				.consumerMainThread(AcaciaChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(BirchChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(BirchChoppedC2SPacket::new)
				.encoder(BirchChoppedC2SPacket::toBytes)
				.consumerMainThread(BirchChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(CrimsonStemChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(CrimsonStemChoppedC2SPacket::new)
				.encoder(CrimsonStemChoppedC2SPacket::toBytes)
				.consumerMainThread(CrimsonStemChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(DarkOakChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(DarkOakChoppedC2SPacket::new)
				.encoder(DarkOakChoppedC2SPacket::toBytes)
				.consumerMainThread(DarkOakChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(JungleChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(JungleChoppedC2SPacket::new)
				.encoder(JungleChoppedC2SPacket::toBytes)
				.consumerMainThread(JungleChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(MangroveChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(MangroveChoppedC2SPacket::new)
				.encoder(MangroveChoppedC2SPacket::toBytes)
				.consumerMainThread(MangroveChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(OakChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(OakChoppedC2SPacket::new)
				.encoder(OakChoppedC2SPacket::toBytes)
				.consumerMainThread(OakChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(SpruceChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpruceChoppedC2SPacket::new)
				.encoder(SpruceChoppedC2SPacket::toBytes)
				.consumerMainThread(SpruceChoppedC2SPacket::handle)
				.add();
        net.messageBuilder(WarpedStemChoppedC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(WarpedStemChoppedC2SPacket::new)
				.encoder(WarpedStemChoppedC2SPacket::toBytes)
				.consumerMainThread(WarpedStemChoppedC2SPacket::handle)
				.add();
        
        //Logs--Chopped------S2C
        net.messageBuilder(AcaciaChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(AcaciaChoppedDataSyncS2CPacket::new)
				.encoder(AcaciaChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(AcaciaChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(BirchChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(BirchChoppedDataSyncS2CPacket::new)
				.encoder(BirchChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(BirchChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(CrimsonStemChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(CrimsonStemChoppedDataSyncS2CPacket::new)
				.encoder(CrimsonStemChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(CrimsonStemChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(DarkOakChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(DarkOakChoppedDataSyncS2CPacket::new)
				.encoder(DarkOakChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(DarkOakChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(JungleChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(JungleChoppedDataSyncS2CPacket::new)
				.encoder(JungleChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(JungleChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(MangroveChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(MangroveChoppedDataSyncS2CPacket::new)
				.encoder(MangroveChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(MangroveChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(OakChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(OakChoppedDataSyncS2CPacket::new)
				.encoder(OakChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(OakChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(SpruceChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(SpruceChoppedDataSyncS2CPacket::new)
				.encoder(SpruceChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(SpruceChoppedDataSyncS2CPacket::handle)
				.add();
        net.messageBuilder(WarpedStemChoppedDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
				.decoder(WarpedStemChoppedDataSyncS2CPacket::new)
				.encoder(WarpedStemChoppedDataSyncS2CPacket::toBytes)
				.consumerMainThread(WarpedStemChoppedDataSyncS2CPacket::handle)
				.add();
        
        
        
		//PRESI'S MAGIC TO BE RELOCATED
		net.messageBuilder(SpawnNatureMagnetItemC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
				.decoder(SpawnNatureMagnetItemC2SPacket::new)
				.encoder(SpawnNatureMagnetItemC2SPacket::toBytes)
				.consumerMainThread(SpawnNatureMagnetItemC2SPacket::handle)
				.add();

    }

    public static <MSG> void sendToServer(MSG message) {
         INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
