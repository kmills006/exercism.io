const dnaNucleotides = ['A', 'C', 'G', 'T'] as const;

type DNA = typeof dnaNucleotides[number];
type RNA = 'A' | 'C' | 'G' | 'U';
type Complement = Record<DNA, RNA>;

const complements: Complement = {
  G: 'C',
  C: 'G',
  T: 'A',
  A: 'U',
};

const isDnaNucleotide = (s: string): s is DNA => dnaNucleotides.includes(s as DNA);

export const dnaToRnaComplement = (dna: string): string => (
  dna.split('')
    .map((n: string): RNA => {
      if (!isDnaNucleotide(n)) {
        throw new Error('Invalid input DNA.');
      }

      return complements[n];
    })
    .join('')
);
