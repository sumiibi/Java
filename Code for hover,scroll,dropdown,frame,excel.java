//Hover
        WebElement element1 = dr.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[8]/ul/li[3]/a/span[1]/span/span"));
        Actions ac = new Actions(dr);
        ac.moveToElement(element1).click().build().perform();
		
//Dropdown
        WebElement em = dr.findElement(By.xpath("//*[@id=\"continents\"]"));
        Select drop = new Select(em);
        drop.selectByIndex(3);
		
//Scroll
        WebElement lang = dr.findElement(By.xpath("//*[@id=\"continents\"]"));
		((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView();", lang);
		
//Frame
		dr.switchTo().frame("iframe1");
		dr.findElement(By.name("firstname")).sendKeys("Ibrahim");
		dr.switchTo().parentFrame();
		dr.switchTo().frame("iframe2");
		dr.findElement(By.xpath("//*[@id=\"post-9\"]/div/div[1]/div/p[1]/a/img")).click();

//Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\selenium\\error.png"));
		
//Excel
		FileInputStream fs = new FileInputStream("C:\\Users\\1354518\\Desktop\\Work\\mysheet.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		
		int row = sh.getRows();
		for (int i = 0; i < row; i++)
		{
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(sh.getCell(0, i).getContents());
			driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,250);");
		}
