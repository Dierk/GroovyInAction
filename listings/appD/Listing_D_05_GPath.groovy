import groovy.xml.dom.DOMCategory

def recipeXml = '''
<recipe>
   <ingredients>
      <ingredient amount='2 cups'>Self-raising Flour</ingredient>
      <ingredient amount='2 tablespoons'>Icing sugar</ingredient>
      <ingredient amount='2 tablespoons'>Butter</ingredient>
      <ingredient amount='3/4 - 1 cup'>Milk</ingredient>
   </ingredients>
   <steps>
      <step>Preheat oven to 230 degrees celsius</step>
      <step>Sift flour and icing sugar into a bowl</step>
      <step>Melt butter and mix into dry ingredients</step>
      <step>Gradually add milk to the mixture until moist</step>
      <step>Turn onto floured board and cut into portions</step>
      <step>Bake for 15 minutes</step>
      <step>Serve with jam and whipped cream</step>
   </steps>
</recipe>
'''

def recipe  = new XmlSlurper().parseText(recipeXml)

assert 4 == recipe.ingredients.ingredient.size()
// should be 14 elements in total
assert 14 == recipe.'**'.findAll{true}.size()
// step 4 (index 3 because we start from 0) involves milk
assert recipe.steps.step[3].text().contains('milk')
assert '2 cups' == recipe.ingredients.ingredient[0].'@amount'.toString()
// two ingredients have '2 tablespoons' amount attribute
def ingredients = recipe.ingredients.ingredient.grep{
    it.'@amount' == '2 tablespoons'
}
assert ingredients.size() == 2
// every step has at least 4 words
assert recipe.steps.step.every{
    step -> step.text().tokenize(' ').size() >= 4
}


def recipe2  = new XmlParser().parseText(recipeXml)
/* … processing steps … */
def reader  = new StringReader(recipeXml)
def doc     = groovy.xml.DOMBuilder.parse(reader)
def recipe3  = doc.documentElement
use (groovy.xml.dom.DOMCategory) {
    /* … processing steps … */
}
