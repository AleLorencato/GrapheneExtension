# Graphene Extension - Minecraft 26.1 (NeoForge)

## 📌 Visão Geral

Este projeto é o port oficial da extensão **Graphene** para **Minecraft 26.1** utilizando o **NeoForge** e **Java 25**.
O mod opera em modo **standalone** com integração nativa ao **JEI (Just Enough Items)**.

---

## 🛠️ Especificações Técnicas

| Componente | Versão / Detalhe |
|---|---|
| **Minecraft** | `26.1.2` |
| **Modloader** | `NeoForge 26.1.0-beta` (compatível com 26.1.2) |
| **Java** | `Java 25` (Oracle JDK 25.0.4.1 / Temurin 25) |
| **Gradle** | `Gradle 9.7.1` |
| **NeoGradle / ModDev** | `net.neoforged.moddev:2.0.144` |
| **JEI** | `mezz.jei:jei-26.1.2-neoforge:29.37.0.98` |

---

## 🔄 Principais Mudanças na Arquitetura (Minecraft 26.1 / NeoForge 26.1)

### 1. `ResourceLocation` substituído por `Identifier`
A classe clássica `net.minecraft.resources.ResourceLocation` foi renomeada para `net.minecraft.resources.Identifier`.
- Uso no código: `Identifier.fromNamespaceAndPath(MOD_ID, "path")` ou `Identifier.withDefaultNamespace("path")`.

### 2. Sistema de `ToolMaterial` como Record
`Tier` agora é `ToolMaterial`, implementado como um `record` imutável da Mojang contendo:
- Tag de blocos mineráveis incorretos (`incorrectBlocksForDrops`)
- Usos/durabilidade (`durability`)
- Velocidade de mineração (`speed`)
- Bônus de ataque (`attackDamageBonus`)
- Encantabilidade (`enchantmentValue`)
- Tag de itens para reparo (`repairItems`)

### 3. Sistema de `ArmorMaterial` e `EquipmentAsset`
- `ArmorMaterial` agora é um `record` nativo.
- As texturas de armaduras foram desacopladas do modelo clássico e agora utilizam o sistema **Equipment Asset**:
  - Assets definidos em `assets/grapheneextension/equipment/graphene.json` com layers `humanoid`, `humanoid_baby` e `humanoid_leggings`.
  - Texturas localizadas em `assets/grapheneextension/textures/entity/equipment/humanoid/graphene.png` e `humanoid_leggings/graphene.png`.
  - Gerador automatizado em `ModEquipmentAssetProvider.java`.

### 4. Obrigatório `setId` no Registro de Itens e Blocos
Em 26.1, `Item.Properties` e `BlockBehaviour.Properties` disparam `NullPointerException: Item id not set` / `Block id not set` caso sejam instanciados sem ID explícito.
- O mod utiliza `BLOCKS.registerBlock(name, func, properties)` e `ITEMS.registerItem(name, func, properties)` que definem automaticamente `properties.setId(...)`.

### 5. Propriedades de Itens Auxiliares
Os construtores de ferramentas e armaduras delegam propriedades através dos helpers fluentes de `Item.Properties`:
- `.sword(tier, baseDamage, attackSpeed)`
- `.pickaxe(tier, baseDamage, attackSpeed)`
- `.axe(tier, baseDamage, attackSpeed)`
- `.shovel(tier, baseDamage, attackSpeed)`
- `.hoe(tier, baseDamage, attackSpeed)`
- `.humanoidArmor(material, type)`

### 6. Divisão de Datagen (`clientData` e `serverData`)
A Mojang dividiu a execução de datagen em `net.minecraft.client.data.Main` e `net.minecraft.data.Main`:
- No `build.gradle`, o bloco `runs` configura `clientData` com saída para `src/generated/client` e `serverData` com saída para `src/generated/server`.
- O `HashCache` de cada gerador roda de forma isolada, evitando que um remova os arquivos gerados pelo outro como "stale".
- Ambas as pastas são declaradas no `sourceSets.main.resources`.
- Uma task composta `runData` executa ambos sequencialmente.

### 7. Datagen de Modelos com `ModelProvider` Vanilla
Os antigos `BlockStateProvider` e `ItemModelProvider` legados foram substituídos pelo `ModelProvider` nativo da Mojang em `ModModelProvider.java`:
- Gera estados de blocos simples (`createTrivialBlock`), modelos de blocos e modelos de itens (`generateFlatItem`, armaduras trimmáveis com `ItemModelGenerators`).

### 8. `@EventBusSubscriber` Moderno
No FancyModLoader 11 / NeoForge 26.1, o atributo `bus = Bus.MOD` foi descontinuado do `@EventBusSubscriber`.

---

## ⚖️ Balanceamento & Drops

- **Minério de Grafeno (Stone e Deepslate):** Drop nerfado para **1 raw_graphene** base (afetado por Fortuna e Toque Suave).
- **Nether e End:** Mantêm valores balanceados com drop customizado de fragmentos/poeiras.

---

## 🚀 Como Compilar e Executar

Execute os comandos a partir da raiz de `Graphene-26.1`:

```powershell
# Compilar classes Java 25
.\gradlew.bat compileJava

# Executar geração de dados (receitas, modelos, tags, loot tables, equipment assets)
.\gradlew.bat runData

# Construir pacote final JAR para distribuição
.\gradlew.bat build
```

O arquivo gerado estará disponível em `build/libs/grapheneextension-26.1-1.0.0.jar`.
