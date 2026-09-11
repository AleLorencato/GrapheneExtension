# Documentação Oficial — Graphene Extension Mod (1.21.1)

## 1. Visão Geral do Projeto
- **Nome:** Graphene Extension (`grapheneextension`)
- **Versão:** `1.21.1-0.1.0`
- **Plataforma:** Minecraft `1.21.1`, NeoForge `21.1.250`
- **Mapeamentos:** Parchment `2024.11.17-1.21.1` (Java 21)
- **Pacote Principal:** `net.ale.grapheneextension`

---

## 2. Conteúdo do Mod

### 2.1. Itens e Materiais
- `graphene` (Grafeno): Material principal utilizado na confecção de blocos compactados, armaduras e ferramentas.
- `raw_graphene` (Grafeno Bruto): Minério cru dropado ao minerar os blocos de minério de grafeno nas dimensões.
- `graphene_dust` (Pó de Grafeno): Pó obtido ao assar o grafeno bruto na fornalha (1:1) ou processá-lo no Mekanism (1:2).

### 2.2. Ferramentas (Tier de Grafeno)
- **Tier:** Nível acima do Netherite.
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
- **Proteção Total:** `25` pontos (Capacete: 5, Peitoral: 9, Calça: 7, Botas: 4).
- **Durabilidade (Multiplicador 31):** Capacete: 341, Peitoral: 496, Calça: 496, Botas: 403.
- **Resistência de Armadura (Toughness):** `3.0f`.
- **Resistência à Repulsão (Knockback Resistance):** `0.05f`.
- **Encantabilidade:** `25`.
- Suporte a Armor Trims (`ItemTags.TRIMMABLE_ARMOR`).

### 2.4. Blocos e Minérios
- `graphene_block`: Bloco decorativo/compactação (9 Grafenos).
- `graphene_ore` (Overworld Pedra): Dropa 1x Grafeno Bruto (+ Fortune/Silk Touch), XP 3-6. Requer Picareta de Ferro.
- `deepslate_graphene_ore` (Overworld Ardósia): Dropa 1x Grafeno Bruto (+ Fortune/Silk Touch), XP 4-8. Requer Picareta de Ferro.
- `nether_graphene_ore` (Nether): Dropa Grafeno Bruto (+ Fortune/Silk Touch), XP 3-7. Requer Picareta de Ferro.
- `end_stone_graphene_ore` (The End): Dropa Grafeno Bruto (+ Fortune/Silk Touch), XP 5-10. Requer Picareta de Netherite.

### 2.5. Geração de Mundo (WorldGen)
- **Overworld:** 12 veios por chunk, tamanho do veio 9, camadas Y=-64 a Y=96.
- **Nether:** 12 veios por chunk, tamanho do veio 9, camadas Y=5 a Y=120.
- **End:** 12 veios por chunk, tamanho do veio 9, camadas Y=-64 a Y=100.

### 2.6. Integração Tecnológica e Standalone
- **Modo Standalone:** O mod funciona perfeitamente sem nenhum outro mod instalado.
- **Mekanism 1.21.1:** Quando o mod `mekanism` estiver presente, receitas de compatibilidade adicionais são ativadas:
  - **Enrichment Chamber:** 1 Grafeno Bruto $\rightarrow$ 2 Pós de Grafeno.
  - **Crusher:** 1 Grafeno Bruto $\rightarrow$ 2 Pós de Grafeno.
  - **Enrichment Chamber (Minério):** 1 Minério de Grafeno $\rightarrow$ 2 Pós de Grafeno.
- **Tags Universais:** Suporte completo ao padrão convencional `c:` da versão 1.21 (`c:ores`, `c:ores/graphene`, `c:raw_materials`, `c:raw_materials/graphene`, `c:dusts`, `c:dusts/graphene`, `c:ingots`, `c:ingots/graphene`) além de apelidos para `forge:`.
