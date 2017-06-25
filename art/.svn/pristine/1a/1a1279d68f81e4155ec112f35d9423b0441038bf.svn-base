package com.golead.art.literature.service.impl;



public class ArtLiteratureServiceImpl {
	/**private static final long serialVersionUID = 1L;

	public ArtLiterature getArtLiterature(Serializable id) throws ServiceException {
		try {
			return artLiteratureDao.get(id);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void createArtLiterature(ArtLiterature artLiterature, List<File> files, String filesFileName) throws ServiceException {
		try {
			StringBuffer attachment = new StringBuffer();
			String[] attachmentNames;
			if (files != null) {
				attachmentNames = filesFileName.split(",");
				for (int i = 0; i < files.size(); i++) {
					String newName = String.valueOf(System.currentTimeMillis());
					String endLess = attachmentNames[i].split("\\.")[1];
					attachment.append(newName + "." + endLess);
					if (i + 1 != files.size()) {
						attachment.append(";");
					}
				}
			}
			artLiterature.setAttachment(attachment.toString());
			artLiteratureDao.save(artLiterature);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void updateArtLiterature(Map<String, String> artLiteratureMap, List<File> files, String oldFileName, String filesFileName, String path) throws ServiceException {
		try {
            Integer pkId = new Integer(artLiteratureMap.get(ArtLiterature.PROP_ID));
			ArtLiterature tmp = artLiteratureDao.get(pkId);
			ConvertUtil.mapToObject(tmp, artLiteratureMap, true);

			tmp.setAuthor(Integer.valueOf(artLiteratureMap.get("artArtistId")));
			String category = artLiteratureMap.get("category").toString();
			tmp.setCategory(category);
			
			StringBuffer newAttachment = new StringBuffer();
			
			String attachment;//数据库值
			String[] deleteAttachments = null;//需要删除的附件
			
			if (tmp.getAttachment() != null && !"".equals(tmp.getAttachment())) {
				attachment = tmp.getAttachment();
				deleteAttachments = attachment.replace(oldFileName, "").split(";");
				File file = new File(path);
				File[] fileList = file.listFiles();
				if (fileList != null) {
					for (File inFile : fileList) {
						for (String deleteAttachment : deleteAttachments) {
							if (deleteAttachment.equals(inFile.getName())) {
								inFile.delete();
							}
						}
					}
					File[] fileList2 = new File(path).listFiles();
					if (fileList2.length == 0) {
						file.delete();
					}
				}
				if (oldFileName.length() > 0) {
					newAttachment.append(oldFileName + ";");
				}
			}
			
			if (files != null) {
				String[] attachmentNames = filesFileName.split(",");
				for (int i = 0; i < files.size(); i++) {
					File file = files.get(i);
					String newName = String.valueOf(System.currentTimeMillis());
					String endLess = attachmentNames[i].split("\\.")[1];
					FileUtils.fileUpload(path + File.separator + newName + "." + endLess, file);
					newAttachment.append(newName + "." + endLess);
					if (i + 1 != files.size()) {
						newAttachment.append(";");
					}
				}
			}
			tmp.setAttachment(newAttachment.toString());
			artLiteratureDao.update(tmp);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void deleteArtLiterature(Serializable id) throws ServiceException {
		try {
			artLiteratureDao.delete(id);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public void deleteArtLiteratures(Serializable[] ids) throws ServiceException {
		try {
			String FILE_PATH = ServletActionContext.getServletContext().getRealPath("");
			for (Serializable id : ids) {
				String path = FILE_PATH + File.separator + "upload" + File.separator + "literature" + File.separator + "information" + File.separator + id.toString();
				File file = new File(path);
				File[] fileList = file.listFiles();
				if (fileList != null) {
					for (File inFile : fileList) {
						inFile.delete();
					}
					File[] fileList2 = new File(path).listFiles();
					if (fileList2.length == 0) {
						file.delete();
					}
				}
			}
			artLiteratureDao.deleteAll(ids);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}

	public String importLiterature(String path) throws ServiceException {
		String message = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
			HSSFSheet sht = wb.getSheetAt(0);
			Map<String, String> artistMap = new HashMap<String, String>();
			List<ArtArtist> artArtists = artArtistService.findAllArtArtist();
	         for(ArtArtist artArtist : artArtists){
	            artistMap.put(artArtist.getCname(), artArtist.getId().toString());
	            artistMap.put(artArtist.getEname(), artArtist.getId().toString());
	         }
			if (sht != null) {
				for (int rowNum = 2; rowNum < sht.getLastRowNum(); rowNum++) {
					HSSFRow hssfRow = sht.getRow(rowNum);
					if(hssfRow == null) continue;
					if (hssfRow.getCell(0) == null) {
						message = "成功操作到第" + String.valueOf(rowNum) + "行";
						break;
					}
					if(("").equals(getValue(hssfRow.getCell(0)))) {
						message = "成功操作到第" + String.valueOf(rowNum) + "行";
						break;
					}
					ArtLiterature artLiterature = new ArtLiterature();
					String str = "";
					Date time = null;
					SysCode code = null;
					int thisRowNum = rowNum + 1;//当前excel表格行
					str = getValue(hssfRow.getCell(0));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到名称";
						break;
					} else if (str.length() > 200) {
						message = "第" + String.valueOf(thisRowNum) + "行名称过长";
						break;
					}
					artLiterature.setLiteratureName(str);
					str = getValue(hssfRow.getCell(1));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行期数找不到";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行期数过长";
						break;
					}
					artLiterature.setPeriod(str);
					str = getValue(hssfRow.getCell(2));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到总期数";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行总期数过长";
						break;
					}
					artLiterature.setTotalPeriod(str);
					str = getValue(hssfRow.getCell(3));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到出版社";
						break;
					} else if (str.length() > 100) {
						message = "第" + String.valueOf(thisRowNum) + "行出版社过长";
						break;
					}
					artLiterature.setPress(str);
					time = hssfRow.getCell(4).getDateCellValue();
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到出版时间";
						break;
					}
					artLiterature.setPublicationTime(time);
					str = getValue(hssfRow.getCell(5));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到总页数";
						break;
					} else if (str.length() > 11) {
						message = "第" + String.valueOf(thisRowNum) + "行总页数过长";
						break;
					}
					artLiterature.setPageCount(Integer.valueOf(str));
					str = getValue(hssfRow.getCell(6));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到主编";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行主编过长";
						break;
					}
					artLiterature.setEditor(str);
					str = getValue(hssfRow.getCell(7));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到副主编";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行副主编过长";
						break;
					}
					artLiterature.setSubeditor(str);
					str = getValue(hssfRow.getCell(8));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到执行主编";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行执行主编过长";
						break;
					}
					artLiterature.setExecutiveEditor(str);
					str = getValue(hssfRow.getCell(9));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到顾问";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行顾问过长";
						break;
					}
					artLiterature.setAdviser(str);
					str = getValue(hssfRow.getCell(10));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到栏目";
						break;
					} else if (str.length() > 200) {
						message = "第" + String.valueOf(thisRowNum) + "行栏目过长";
						break;
					}
					artLiterature.setLiteratureColumn(str);
					str = getValue(hssfRow.getCell(11));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到内容名称";
						break;
					} else if (str.length() > 500) {
						message = "第" + String.valueOf(thisRowNum) + "行内容名称过长";
						break;
					}
					artLiterature.setContentName(str);
					str = getValue(hssfRow.getCell(12));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到内容类型";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行内容类型过长";
						break;
					}
					artLiterature.setContentType(str);
					String artist = getValue(hssfRow.getCell(13));
					if (artistMap.get(artist) == null) {
						message = "第" + String.valueOf(thisRowNum) + "行不存在该作者名称，请重新到excel修改";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行作者过长";
						break;
					}
					Integer artistId = Integer.valueOf(artistMap.get(artist));
					artLiterature.setAuthor(artistId);
					str = getValue(hssfRow.getCell(14));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到页码段";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行页码段过长";
						break;
					}
					artLiterature.setPageSegment(str);
					str = getValue(hssfRow.getCell(15));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到相关页";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行相关页过长";
						break;
					}
					artLiterature.setRelevantPages(str);
					str = getValue(hssfRow.getCell(16));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到收录类型";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行收录类型过长";
						break;
					}
					code = sysCodeService.findCodeByName(str);
					artLiterature.setLiteratureType(code.getItemValue());
					str = getValue(hssfRow.getCell(17));
					if ("".equals(str)) {
						message = "第" + String.valueOf(thisRowNum) + "行找不到类别";
						break;
					} else if (str.length() > 30) {
						message = "第" + String.valueOf(thisRowNum) + "行类别过长";
						break;
					}
					code = sysCodeService.findCodeByName(str);
					artLiterature.setCategory(code.getItemValue());
					artLiteratureDao.save(artLiterature);
				}
			}
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		File file = new File(path);
		if(file.exists() && file.isFile()){
			file.delete();
		}
		return message;
	}
	
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			DecimalFormat df = new DecimalFormat("0");
			return df.format(hssfCell.getNumericCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_FORMULA) {
			// 返回数值类型的值
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	public PageQuery queryArtLiterature(PageQuery pageQuery) throws ServiceException {
		try {
		  createSqlFilter(pageQuery);
          return jdbcDao.queryBySqlId("artLiteratureList", pageQuery);
        } catch (DAOException e) {
          e.printStackTrace();
          throw new ServiceException("数据库操作错误。");
        } catch (ServiceException se) {
          se.printStackTrace();
          throw se;
        } catch (Exception e) {
          e.printStackTrace();
          throw new ServiceException("系统错误。");
        }
	}
	
	private void createSqlFilter(PageQuery page) {
		String paras = "";
		String literatureName = page.getParameters().get("literatureName");
		if (literatureName != null && !"".equals(literatureName)) {
			if (paras.length() > 0) {
				paras += " and ";
			}
			paras += " literature_name like '%" + literatureName + "%'";
		}
		String author = page.getParameters().get("artistId");
		if (author != null && !"".equals(author)) {
			if (paras.length() > 0) {
				paras += " and ";
			}
			paras += " author = '" + author + "'";
		}
		if (paras.length() > 0) {
			page.getParameters().put("paras", paras);
		}
	}
	
    @Resource
	private ArtLiteratureDao	artLiteratureDao;
    
    @Resource
    private ArtArtistService artArtistService;
    
    @Resource
	private SysCodeService	sysCodeService;

	public void setArtLiteratureDao(ArtLiteratureDao artLiteratureDao) {
		this.artLiteratureDao = artLiteratureDao;
	}**/
}

