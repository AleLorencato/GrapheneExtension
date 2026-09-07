# Documentação Oficial & Roadmap — Graphene Extension Mod

## 1. Visão Geral do Projeto
- **Nome:** Graphene Extension (`grapheneextension`)
- **Versão:** `1.20.1-0.2.0` (Padrão CurseForge: `[Versão MC]-[Versão Mod]`)
- **Plataforma:** Minecraft `1.20.1`, Minecraft Forge `47.2.30`
- **Mapeamentos:** Parchment `2023.09.03-1.20.1` (Java 17)
- **Pacote Principal:** `net.ale.grapheneextension`

---

## 2. Conteúdo Atual do Mod

### 2.1. Itens e Materiais
- `graphene` (Grafeno): Material principal utilizado na confecção de blocos compactados, armaduras e ferramentas.
- `raw_graphene` (Grafeno Bruto): Minério cru dropado ao minerar os blocos de minério de grafeno nas dimensões.
- `graphene_dust` (Pó de Grafeno): Pó obtido ao assar o grafeno bruto na fornalha (1:1) ou processá-lo em pulverizadores industriais (1:2).

### 2.2. Ferramentas (Tier de Grafeno)
- **Tier:** Nível `5` (registrado após o Netherite via `TierSortingRegistry`).
- **Durabilidade:** `2500` usos.
- **Velocidade de Mineração:** `12.0f`.
- **Dano Base:** `3.0f`.
- **Encantabilidade:** `25`.
- **Item de Reparo:** `graphene`.

| Ferramenta | Dano de Ataque | Velocidade de Ataque | Receita |
| :--- | :--- | :--- | :--- |
| **Espada de Grafeno** (`graphene_sword`) | +4 (Total: 7) | -2.0 (Velocidade final: 2.0) | 2 Grafenos + 1 Graveto |
| **Picareta de Grafeno** (`graphene_pickaxe`) | +2 (Total: 5) | -2.0 (Velocidade final: 2.0) | 3 Grafenos + 2 Gravetos |
| **Machado de Grafeno** (`graphene_axe`) | +6 (Total: 9) | -3.0 (Velocidade final: 1.0) | 3 Grafenos + 2 Gravetos |
| **Pá de Grafeno** (`graphene_shovel`) | +1 (Total: 4) | -2.0 (Velocidade final: 2.0) | 1 Grafeno + 2 Gravetos |
| **Enxada de Grafeno** (`graphene_hoe`) | +1 (Total: 4) | -2.0 (Velocidade final: 2.0) | 2 Grafenos + 2 Gravetos |

### 2.3. Armadura de Grafeno
- **Proteção Total:** `25` pontos (Capacete: 5, Peitoral: 9, Calça: 7, Botas: 4). *Netherite e Diamante possuem 20.*
- **Durabilidade (Multiplicador 31):** Capacete: 341, Peitoral: 496, Calça: 496, Botas: 403.
- **Resistência de Armadura (Toughness):** `3.0f` (igual ao Netherite).
- **Resistência à Repulsão (Knockback Resistance):** `0.05f`.
- **Encantabilidade:** `25`.
- Suporte a Armor Trims (`ItemTags.TRIMMABLE_ARMOR`).

### 2.4. Blocos e Minérios
- `graphene_block`: Bloco decorativo/compactação (9 Grafenos).
- `graphene_ore` (Overworld Pedra): Dropa 1x Pó de Grafeno (+ Fortune), 3-6 XP. Requer ferramenta de Ferro.
- `deepslate_graphene_ore` (Overworld Ardósia): Dropa 1-3x Pó de Grafeno (+ Fortune), 4-8 XP. Requer ferramenta de Ferro.
- `nether_graphene_ore` (Nether): Dropa 2-5x Pó de Grafeno (+ Fortune), 3-7 XP. Requer ferramenta de Ferro.
- `end_stone_graphene_ore` (The End): Dropa 6-10x Pó de Grafeno (+ Fortune), 5-10 XP. Requer ferramenta de Netherite.

### 2.5. Geração de Mundo (WorldGen)
- **Overworld:** 12 veios por chunk, tamanho do veio 9, camadas Y=-64 a Y=96.
- **Nether:** 12 veios por chunk, tamanho do veio 9, camadas Y=5 a Y=120.
- **End:** 12 veios por chunk, tamanho do veio 9, camadas Y=-64 a Y=100.

---

## 3. Roadmap de Desenvolvimento

### 📌 Tarefa 1: Imediata — Balanceamento de Dificuldade (Concluída ✅)
- [x] Alterar receitas de fundição (Fornalha e Alto-Forno):
  - Blocos de minério assados resultam em **Pó de Grafeno** (`graphene_dust`), ao invés de Grafeno direto.
  - Remover a fundição 1:1 de Pó de Grafeno para Grafeno.
- [x] Adicionar receita na bancada de trabalho: **8 Pós de Grafeno $\rightarrow$ 1 Grafeno** (`graphene`).
- [x] Executar `./gradlew runData` para atualizar os arquivos gerados.

### 📌 Tarefa 2: Versão 1.0 (Concluída ✅)
- [x] Adicionar o item Minério de Grafeno Bruto (`raw_graphene`).
- [x] Atualizar loot tables dos blocos de minério para droparem `raw_graphene` (suportando Fortune e Silk Touch).
- [x] Criar mecânica de processamento no Minecraft Vanilla:
  - 1 `raw_graphene` $\rightarrow$ 1 `graphene_dust` (Fornalha e Alto-Forno).
- [x] Adicionar suporte a mods tecnológicos via datapack / tags universais:
  - **Thermal Expansion (Pulverizer):** 1 minério bruto $\rightarrow$ 2 pós de grafeno.
  - **Mekanism (Crusher / Enrichment):** 1 minério bruto $\rightarrow$ 2 pós de grafeno.
  - Compatibilidade com tags `forge:ores`, `forge:raw_materials`, `forge:dusts`, `forge:ingots`.

### 📌 Tarefa 3: Avançada (Major Release Futura — Super Grafeno)
- [ ] Criar novo tier de material: "Super Grafeno".
- [ ] Mecânica avançada de produção exigindo integração com máquinas de alta temperatura/pressão do Mekanism e Thermal Expansion.
- [ ] Novo set de armadura e ferramentas com atributos e efeitos especiais acima do Netherite.
- [ ] Design visual e texturas exclusivas.
