execute as @p at @s run effect give @e[type=minecraft:villager, distance=..100, nbt={VillagerData: {profession: "minecraft:armorer"}}] minecraft:glowing 5 1 true
tellraw @a[distance=..100] {"translate":"cxivov_mod.zlate_stranky.chat.armorer","with":[{"selector":"@p"}],"italic":true,"color":"gold"}