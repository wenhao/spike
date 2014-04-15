describe('Javascript', function() {
    it('adds two numbers together', function() {
        expect(1 + 2).toEqual(3);
    });
});

describe('A suite', function() {
    it('contains spec with an expectation', function() {
        expect(true).toBe(true);
    });
});

describe('A suite is just a function', function() {
    var a;

    it('and so is a spec', function() {
        a = true;
        expect(a).toBe(true);
    });
});

describe("The 'ToBe' matcher compares with ===", function() {
    it('and has a positive case', function() {
        expect(true).toBe(true);
    });

    it("and can have a negative case", function() {
        expect(false).not.toBe(true);
    });

});

describe('Included matchers:', function() {
    it("The 'toBe' matcher compares with ===", function() {
        var a = 12;
        var b = a;

        expect(a).toBe(12);
        expect(a).not.toBe(null);
    });

    describe("The 'toEqual' matcher", function() {
        it("works for simple literals and variables", function() {
            var a = 12;
            expect(a).toEqual(12);
        });

        it("should work for objects", function() {
            var foo = {
                a: 12,
                b: 34
            };
            var bar = {
                a: 12,
                b: 34
            };
            expect(foo).toEqual(bar);
        });

        it("The 'toMatch' matcher is for regular expression", function() {
            var message = "foo bar baz";
            expect(message).toMatch(/bar/);
            expect(message).toMatch("bar");
            expect(message).not.toMatch(/quux/);
        });

        it("The 'toBeDefined' matcher compares against 'undefined'", function() {
            var a = {
                foo: "foo"
            };
            expect(a.foo).toBeDefined();
            expect(a.bar).not.toBeDefined();
        });

        it("The 'toBeUndefined' matcher compares against 'undefined'", function() {
            var a = {
                foo: "foo"
            };
            expect(a.foo).not.toBeUndefined();
            expect(a.bar).toBeUndefined();
        });

        it("The 'toBeNull' matcher compares against null", function() {
            var a = null;
            var foo = "foo";
            expect(null).toBeNull();
            expect(a).toBeNull();
            expect(foo).not.toBeNull();
        });

        it("The 'toBeTruthy' matcher is for boolean casting testing", function() {
            var a, foo = "foo";
            expect(foo).toBeTruthy();
            expect(a).not.toBeTruthy();
        });

        it("The 'toBeFalsy' matcher is for boolean casting testing", function() {
            var a, foo = "foo";
            expect(a).toBeFalsy();
            expect(foo).not.toBeFalsy();
        });

        it("The 'toContain' matcher is for finding an item in an array", function() {
            var a = ["foo", "bar", "baz"];

            expect(a).toContain("bar");
            expect(a).not.toContain("quux");
        });

        it("The 'toBeLessThan' matcher is for mathematical comparisons", function() {
           var pi = 3.1415926,
                e = 2.78;

           expect(e).toBeLessThan(pi);
           expect(pi).not.toBeLessThan(e);
        });

        it("The 'toBeGreaterThan' matcher is for mathematical comparisons", function() {
            var pi = 3.1415926,
                e = 2.78;
            expect(pi).toBeGreaterThan(e);
            expect(e).not.toBeGreaterThan(pi);
        });

        it("The 'toBeCloseTo' matcher is for precision math comparisons", function() {
            var pi = 3.1415926,
                e = 2.78;
            expect(pi).not.toBeCloseTo(e, 2);
            expect(pi).toBeCloseTo(e, 0);
        });

        it("The 'toThrow' is testing for a function throws an exception", function() {
            var foo = function() {
                return 1 + 2;
            };
            var bar = function() {
                return a + 1;
            };
            expect(foo).not.toThrow();
            expect(bar).toThrow();
        });
    });
});

describe("A Spec", function() {
    it("is just a function, so it can contain any code", function() {
        var foo = 0;
        foo += 1;
        expect(foo).toEqual(1);
    });

    it("can have more than one expectation", function() {
        var foo = 0;
        foo += 1;
        expect(foo).toBe(1);
        expect(true).toBeTruthy();
    });
});

describe("A Spec (with setup and tear-down)", function() {
    var foo;

    beforeEach(function() {
        foo = 0;
        foo += 1;
    });

    afterEach(function() {
        foo = 0;
    });

    it("is just a function, so it can contain any code", function() {
        expect(foo).toEqual(1);
    });

    it("can have more than one expectation", function() {
        expect(foo).toBe(1);
        expect(true).toBe(true);
    });

    describe("nested inside a second describe", function() {
        var bar;

        beforeEach(function() {
            bar = 1;
        });
        it("can reference both describe variables", function() {
            expect(foo).toEqual(bar);
        });
    });
});

xdescribe("A Spec", function() {
    var foo;

    beforeEach(function() {
        foo = 0;
        foo += 1;
    });

    it("is just a function, so it can contain any code", function() {
        expect(foo).toEqual(1);
    });
});

describe("Pending specs", function() {
    xit("can be declared 'xit'", function() {
        expect(true).toBe(true);
    });

    it("can be declared with 'it' but without a function");

    it("can be declared by calling 'pending' in the spec body", function() {
        expect(true).toBe(true);
    });
});

describe("A Spy", function() {
    var foo, bar = null;
    beforeEach(function() {
        foo = {
            setBar: function(value) {
                bar = value;
            }
        };

        spyOn(foo, "setBar");
        foo.setBar(123);
        foo.setBar(456, "another param");
    });

    it("tracks that the spy was called", function() {
        expect(foo.setBar).toHaveBeenCalled();
    });

    it("tracks all the arguments of its calls", function() {
        expect(foo.setBar).toHaveBeenCalledWith(123);
        expect(foo.setBar).toHaveBeenCalledWith(456, "another param");
    });

    it("stops all execution on a function", function() {
        expect(bar).toBeNull();
    });
});

describe("A Spec, when configured to call through", function() {
    var foo, bar, fetchedBar;

    beforeEach(function() {
        foo = {
            setBar: function(value){
                bar = value;
            },
            getBar: function() {
                return bar;
            }
        };
        spyOn(foo, 'getBar').andCallThrough();

        foo.setBar(123);
        fetchedBar = foo.getBar();
    });

    it("tracks that the spy was called", function() {
        expect(foo.getBar).toHaveBeenCalled();
    });

    it("should not effect other functions", function() {
        expect(bar).toEqual(123);
    });

    it("when called returns the requested value", function() {
        expect(fetchedBar).toBe(123);
    });
});

describe("A Spec, when configured to fake a return value", function() {
    var foo, bar, fetchedBar;
    beforeEach(function() {
        foo = {
            setBar: function(value) {
                bar = value;
            },
            getBar: function() {
                return bar;
            }
        };
        spyOn(foo, "getBar").andReturn(745);
        foo.setBar(123);
        fetchedBar = foo.getBar();
    });

    it("tracks that the spy was called", function() {
        expect(foo.getBar).toHaveBeenCalled();
    });

    it("should not effect other functions", function() {
        expect(bar).toBe(123);
    });

    it("when callled returns the requested value", function() {
        expect(fetchedBar).toBe(745);
    });
});

describe("A Spec, when configured with an alternate implementation", function() {
    var foo, bar, fetchedBar;
    beforeEach(function() {
        foo = {
            setBar: function(value) {
                bar = value;
            },
            getBar: function() {
                return value;
            }
        };

        spyOn(foo, 'getBar').andCallFake(function() {
            return 1001;
        });
        foo.setBar(123);
        fetchedBar = foo.getBar();
    });

    it("tracks that the spy was called", function() {
        expect(foo.getBar).toHaveBeenCalled();
    });

    it("should not effect other functions", function() {
        expect(bar).toEqual(123);
    });

    it("when called returns the requested value", function(){
        expect(fetchedBar).toBe(1001);
    });
});