import { isPangram } from './pangram'

describe('Pangram()', () => {
  it('empty sentence', () => {
    expect(isPangram('')).toBe(false);
  });

  it('pangram with only lower case', () => {
    const actual = isPangram("the quick brown fox jumps over the lazy dog");
    expect(actual).toBe(true);
  });

  it("missing character 'x'", () => {
    const actual = isPangram("a quick movement of the enemy will jeopardize five gunboats");
    expect(actual).toBe(false);
  });

  it("another missing character 'x'", () => {
    const actual = isPangram("the quick brown fish jumps over the lazy dog");
    expect(actual).toBe(false);
  });

  it("pangram with underscores", () => {
    const actual = isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog");
    expect(actual).toBe(true);
  });

  it("pangram with numbers", () => {
    const actual = isPangram("the 1 quick brown fox jumps over the 2 lazy dogs");
    expect(actual).toBe(true);
  });

  it('missing letters replaced by numbers', () => {
    const actual = isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog");
    expect(actual).toBe(false);
  });

  it('pangram with mixed case and punctuation', () => {
    const actual = isPangram("\"Five quacking Zephyrs jolt my wax bed.\"");
    expect(actual).toBe(true);
  });

  it('pangram with non-ascii characters', () => {
    const actual = isPangram("Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich.");
    expect(actual).toBe(true);
  });
})
