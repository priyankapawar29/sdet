package Groovyactivities

class Activity4 {
	static void main(def args) {
		def str = "This is a Groovy Language"
		
		//Reversing the string
		def revStr = str.reverse()
		println "Reversed string: " + revStr
		
		//Printing a subString
		def subStr = str.substring(10)
		println "Sub string: " + subStr
		
		//Splitting the string
		def splitStr = str.split(" ")
		println "Split string: " + splitStr
		
		//Removing words from the string
		def minusStr = str.minus("Groovy")
		println "String after removal: " + minusStr
		
		//Removing words from the string
		def lowerStr = str.toLowerCase()
		def upperStr = str.toUpperCase()
		println "Lower case string: " + lowerStr
		println "Upper case string: " + upperStr
		
		//REGEX OPERATIONS
		//matches()
		def matchStatus = str.matches("(.*)Groovy(.*)")
		if(matchStatus) { println "String matches" }
		
		//replaceAll()
		def replaceWith = "very Groovy"
		println(str.replaceAll("Groovy", replaceWith))
		//Notice that the original string is not changed
		println str
	}
}
