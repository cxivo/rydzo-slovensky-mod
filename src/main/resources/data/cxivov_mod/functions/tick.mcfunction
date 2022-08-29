scoreboard players enable @a villagers
execute as @a[scores={villagers=1}] run function cxivov_mod:highlight_all
execute as @a[scores={villagers=2}] run function cxivov_mod:highlight_armorer
execute as @a[scores={villagers=3}] run function cxivov_mod:highlight_butcher
execute as @a[scores={villagers=4}] run function cxivov_mod:highlight_cartographer
execute as @a[scores={villagers=5}] run function cxivov_mod:highlight_cleric
execute as @a[scores={villagers=6}] run function cxivov_mod:highlight_farmer
execute as @a[scores={villagers=7}] run function cxivov_mod:highlight_fisherman
execute as @a[scores={villagers=8}] run function cxivov_mod:highlight_fletcher
execute as @a[scores={villagers=9}] run function cxivov_mod:highlight_leatherworker
execute as @a[scores={villagers=10}] run function cxivov_mod:highlight_librarian
execute as @a[scores={villagers=11}] run function cxivov_mod:highlight_mason
execute as @a[scores={villagers=12}] run function cxivov_mod:highlight_shepherd
execute as @a[scores={villagers=13}] run function cxivov_mod:highlight_toolsmith
execute as @a[scores={villagers=14}] run function cxivov_mod:highlight_weaponsmith
execute as @a[scores={villagers=15}] run function cxivov_mod:highlight_nitwit
execute as @a[scores={villagers=16}] run function cxivov_mod:highlight_none
execute as @a[scores={villagers=17}] run function cxivov_mod:highlight_wandering

scoreboard players reset @a[scores={villagers=1..}] villagers