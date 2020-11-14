import { dnaToRnaComplement } from './rna-transcription'

describe('Transcriptor', () => {
  it('transcribes cytosine to guanine', () => {
    expect(dnaToRnaComplement('C')).toEqual('G')
  })

  it('transcribes guanine to cytosine', () => {
    expect(dnaToRnaComplement('G')).toEqual('C')
  })

  it('transcribes adenine to uracil', () => {
    expect(dnaToRnaComplement('A')).toEqual('U')
  })

  it('transcribes thymine to adenine', () => {
    expect(dnaToRnaComplement('T')).toEqual('A')
  })

  it('transcribes all dna nucleotides to their rna complements', () => {
    expect(dnaToRnaComplement('ACGTGGTCTTAA'))
      .toEqual('UGCACCAGAAUU')
  })

  it('correctly handles invalid input', () => {
    expect(() => dnaToRnaComplement('U')).toThrowError(
      'Invalid input DNA.'
    )
  })

  it('correctly handles completely invalid input', () => {
    expect(() => dnaToRnaComplement('XXX')).toThrowError(
      'Invalid input DNA.'
    )
  })

  it('correctly handles partially invalid input', () => {
    expect(() => dnaToRnaComplement('ACGTXXXCTTAA')).toThrowError(
      'Invalid input DNA.'
    )
  })
})
