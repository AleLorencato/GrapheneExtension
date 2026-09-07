# Plano de Implementação — Fase 2: Minério Bruto e Integrações Tecnológicas

Nesta fase, implementaremos o item **Grafeno Bruto (`raw_graphene`)**, atualizaremos os drops dos minérios para que dropem o minério bruto (ao invés de pó direto), manteremos o processamento vanilla na fornalha (1 bruto $\rightarrow$ 1 pó), e adicionaremos compatibilidade com máquinas industriais (**Thermal Expansion** e **Mekanism**) para processar 1 bruto $\rightarrow$ 2 pós de grafeno.

---

## 1. Modificações Propostas

### 1.1. Novos Registros de Itens
- **[MODIFY] [ModItems.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/item/ModItems.java):**
  - Registrar `RAW_GRAPHENE` (`raw_graphene`).
- **[MODIFY] [ModCreativeModTabs.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/item/ModCreativeModTabs.java) e [GrapheneExtension.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/GrapheneExtension.java):**
  - Adicionar `RAW_GRAPHENE` à aba criativa do mod e à aba de ingredientes do Minecraft.
- **[MODIFY] [pt_br.json](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/resources/assets/grapheneextension/lang/pt_br.json) e [en_us.json](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/resources/assets/grapheneextension/lang/en_us.json):**
  - Adicionar `"item.grapheneextension.raw_graphene": "Grafeno Bruto"` / `"Raw Graphene"`.

---

### 1.2. Modelo do Item
- **[MODIFY] [ModItemModelProvider.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/datagen/ModItemModelProvider.java):**
  - Adicionar `simpleItem(ModItems.RAW_GRAPHENE);` (conectando com a textura já existente `raw_graphene.png`).

---

### 1.3. Atualização de Loot Tables (Drops dos Minérios)
- **[MODIFY] [ModBlockLootTables.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/datagen/loot/ModBlockLootTables.java):**
  - Substituir o drop de `GRAPHENE_DUST` por `RAW_GRAPHENE`:
    - `graphene_ore`: 1x Grafeno Bruto (+ Fortuna)
    - `deepslate_graphene_ore`: 1 a 2x Grafeno Bruto (+ Fortuna)
    - `nether_graphene_ore`: 1 a 3x Grafeno Bruto (+ Fortuna)
    - `end_stone_graphene_ore`: 3 a 5x Grafeno Bruto (+ Fortuna)
    - *(Toque Suave / Silk Touch continua dropando o bloco de minério intacto).*

---

### 1.4. Tags Universais Forge (Compatibilidade com Modpacks)
- **[MODIFY] [ModItemTagGenerator.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/datagen/ModItemTagGenerator.java):**
  - Adicionar `raw_graphene` nas tags: `forge:raw_materials`, `forge:raw_materials/graphene`.
  - Adicionar `graphene_dust` nas tags: `forge:dusts`, `forge:dusts/graphene`.
  - Adicionar `graphene` nas tags: `forge:ingots`, `forge:ingots/graphene`.
- **[MODIFY] [ModBlockTagGenerator.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/datagen/ModBlockTagGenerator.java):**
  - Adicionar os minérios nas tags: `forge:ores`, `forge:ores/graphene`.

---

### 1.5. Receitas Vanilla (1:1)
- **[MODIFY] [ModRecipeProvider.java](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/java/net/ale/grapheneextension/datagen/ModRecipeProvider.java):**
  - Adicionar receitas de Fornalha (Smelting) e Alto-Forno (Blasting):
    - **1 Grafeno Bruto $\rightarrow$ 1 Pó de Grafeno** (rendimento vanilla 1:1).
    - Blocos de minério continuam assando para 1 Pó de Grafeno na fornalha.

---

### 1.6. Receitas de Integração Tecnológica (1:2 - Thermal Expansion e Mekanism)
Para permitir que o mod funcione perfeitamente com ou sem esses mods instalados (sem causar falhas quando o jogador não tiver os mods), utilizaremos a flag condicional nativa do Forge (`forge:mod_loaded`):
- **Thermal Expansion (Pulverizer):**
  - `[NEW]` [pulverizer_raw_graphene.json](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/resources/data/grapheneextension/recipes/compat/thermal/pulverizer_raw_graphene.json):
    - Entrada: `grapheneextension:raw_graphene`
    - Saída: `2x grapheneextension:graphene_dust`
    - Condição: mod `thermal` carregado.
  - `[NEW]` [pulverizer_graphene_ore.json](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/resources/data/grapheneextension/recipes/compat/thermal/pulverizer_graphene_ore.json):
    - Entrada: tag `forge:ores/graphene`
    - Saída: `2x grapheneextension:graphene_dust`
    - Condição: mod `thermal` carregado.

- **Mekanism (Enrichment Chamber & Crusher):**
  - `[NEW]` [enriching_raw_graphene.json](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/resources/data/grapheneextension/recipes/compat/mekanism/enriching_raw_graphene.json):
    - Entrada: `grapheneextension:raw_graphene`
    - Saída: `2x grapheneextension:graphene_dust`
    - Condição: mod `mekanism` carregado.
  - `[NEW]` [crushing_raw_graphene.json](file:///d:/Programacao/mods-mine/Graphene-1.20.1/src/main/resources/data/grapheneextension/recipes/compat/mekanism/crushing_raw_graphene.json):
    - Entrada: `grapheneextension:raw_graphene`
    - Saída: `2x grapheneextension:graphene_dust`
    - Condição: mod `mekanism` carregado.

---

## 2. Plano de Verificação

### Compilação e Geração de Dados
1. Executar `./gradlew.bat compileJava` para verificar a compilação do novo item e tags.
2. Executar `./gradlew.bat runData` para gerar os modelos JSON, loot tables de minério bruto e tags do Forge.
3. Executar `./gradlew.bat build` para empacotar o arquivo JAR oficial atualizado.
